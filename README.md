NB: This WIP project currently has three hidden dependencies:
1. a copy of https://github.com/mikekestemont/wuerzb15 must be in its root folder
1. at least two txt files must be provided anywhere within a `data/blogs` subfolder
1. a `data/stopwords.txt` file must be provided for the language the files in 2 are in (even though it's currently unused).


Сваляне на решения:

* КЗК http://reg.cpc.bg/ - има различни видове документи - решения, определения, съобщения.Тъй като имат еднаква структура (http://reg.cpc.bg/AllNewResolutions.aspx?dt=1&ot=2), може всички да се ползват;
* КРС http://www.crc.bg/decisions.php?id=1016

Помощни ресурси:

[Честотни речници на българския език](http://dcl.bas.bg/frequency.html)
[BG stop-words](https://github.com/stopwords-iso/stopwords-bg)
[Advanced Stylometry Course, Wuerzburg](https://github.com/mikekestemont/wuerzb15)

Софтуер за стилометрия:

* Stylo
  * https://sites.google.com/site/computationalstylistics/stylo
  * https://github.com/computationalstylistics/stylo
  * (Java) https://github.com/psal/jstylo
  * https://github.com/psal/JStylo-Anonymouth
* JGAAP
  * https://github.com/evllabs/JGAAP
  * https://github.com/evllabs/JGAAP/releases
* Random projects
  * https://github.com/jpotts18/stylometry

Допълнителни ресурси:

* https://arxiv.org/pdf/1707.03736.pdf (Георги Караджов: това е статия, която сме правили за обратната задача на идентификацията на автор. Това, което може да ви е полезно е всъщност описание на текстови метрики, които се използват за идентификация. За резюме вижте редовете на таблица 2 и раздел 3.1)
* Clustering: https://docs.scipy.org/doc/scipy/reference/generated/scipy.cluster.hierarchy.linkage.html
* Evaluation of text classification: https://nlp.stanford.edu/IR-book/html/htmledition/evaluation-of-text-classification-1.html
* Online tool for authorship: http://www.aicbt.com/authorship-attribution/online-software/ 
* http://aliarsalankazmi.github.io/blog_DA/posts/r/2016/11/18/authorial_analysis_pm.html


