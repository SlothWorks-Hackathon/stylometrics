package sloth.works.hackathon;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PdfMetadata {

    private static final String[] FIELDS = new String[]{
            "Author",
            "creator",
            "meta:author",
            "producer",
            "title",
            "pdf:docinfo:producer",
            "pdf:docinfo:created",
            "pdf:docinfo:creator",
            "dc:creator",
            "meta:creation-date",
            "created",
            "date",
            "Creation-Date",
            "pdf:PDFVersion",
            "pdf:docinfo:title",
            "xmp:CreatorTool",
            "dcterms:created",
            "Last-Modified",
//            "dcterms:modified",
//            "dc:format",
//            "access_permission:modify_annotations",
//            "access_permission:can_print_degraded",
//            "xmpMM:DocumentID",
//            "Last-Save-Date",
//            "pdf:docinfo:creator_tool",
//            "access_permission:fill_in_form",
//            "pdf:docinfo:modified",
//            "meta:save-date",
//            "pdf:encrypted",
//            "dc:title",
//            "modified",
//            "Content-Type",
//            "access_permission:extract_for_accessibility",
//            "access_permission:assemble_document",
//            "xmpTPg:NPages",
//            "access_permission:extract_content",
//            "access_permission:can_print",
//            "access_permission:can_modify",
    };


    private static final String SEPARATOR = ",";
    private static final String OUTPUT_CSV = "output.csv";


    public static void main(final String[] args) throws Exception {
        List<Object[]> fileMetadataList = Files.walk(Paths.get(args[0]))
                .map(Path::toFile)
                .filter(File::isFile)
                .filter(f -> f.getName().endsWith(".pdf"))
                .map(PdfMetadata::getMetadata)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        printHeader();
        fileMetadataList.forEach(PdfMetadata::print);
    }

    private static void printHeader() {
        String header = String.join(SEPARATOR, FIELDS);
        try (FileWriter fw = new FileWriter(OUTPUT_CSV, false)) {
            fw.write("File" + SEPARATOR + header + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print(Object[] fileMetadata) {
        File file = (File) fileMetadata[0];
        Metadata metadata = (Metadata) fileMetadata[1];
        StringBuilder result = new StringBuilder(file.getName() + SEPARATOR);
        for (String name : FIELDS) {
            result.append(metadata.get(name)).append(SEPARATOR);
        }
        result.append("\n");
        try (FileWriter fw = new FileWriter(OUTPUT_CSV, true)) {
            fw.write(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Optional<Object[]> getMetadata(File file) {
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        try (FileInputStream inputstream = new FileInputStream(file)) {
            ParseContext pcontext = new ParseContext();

            //parsing the document using PDF parser
            PDFParser pdfparser = new PDFParser();
            pdfparser.parse(inputstream, handler, metadata, pcontext);
            System.out.println("Metadata: " + file);
            return Optional.of(new Object[]{file, metadata});
        } catch (Exception e) {
            System.out.println("Oooops... " + e.getMessage());
            return Optional.empty();
        }
    }
}
