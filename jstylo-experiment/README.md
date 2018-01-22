## JStylo experiment

Using JStylo we tried to classify blogposts.

The idea behind this was to get blog posts from different bloggers in Bulgarian and try to classify them by author using stylometric analysis.
After that the idea was to determine the features that were most valuable based on the results.

### The test we performed:

#### Data:

We added 15 annotated blog posts per author using 2 authors only.
Then we added 3 blog posts per author to the test set and 2 more posts from unknown author (not matching both of them).

#### Features:

The features we used were from pre-defined Feature set called *"9 feature-set"*.

It includes the following features:

* Unique words count
* Complexity (Ratio of unique words to total number of words in the document.)
* Sentence count
* Avg. sentence length
* Avg. Syllables in word
* Gunning-Frog Readibility index
* Character space
* Letter space
* Flesh reading ease score

#### Classifier

Since we had small number of data we used a fairly simple classifiers: SimpleLinearRegression and SimpleLogistics.

#### Result

With the simple logistics the algorithm managed to classify the blog post very well with one exception:

The unknown blogger was classified as one of the other bloggers with high certainty. The other two bloggers were classified very accurately.

#### Summary

This experiment end-up failing most likely because we lack data.

The JStylo tool seem to be very powerful, though. You can also check its successor JGAAP.


