# Taxonaut: a comparative viewer of multiple hierarchies

Taxonaut is a Java application software to compare multiple hierarchies retrieved from data sources
accessible by GBIF Species API.  Current version is [3.1.5](https://github.com/nomencurator/taxonaut/releases/tag/v3.1.5).
[Executable jar file](https://github.com/nomencurator/taxonaut/releases/download/v3.1.5/Taxonaut-3.1.5-jar-with-dependencies.jar) is available to try on any Java 8 environment including Linux, Mac OS X, Solaris and Windows.
Download the jar file and double click it, or if it does not work, execute java from the command line by typing
```
java -jar Taxonaut-3.1.5-jar-with-dependencies.jar
```
at the directory where the jar file is.  Java Runtime Environment is a available from [download site] (https://java.com/download/), if you do not have.  It is tested with Java version 8.  Network connection to GBIF data server (api.gbif.org) is essential.   See [Wiki page](https://github.com/nomencurator/taxonaut/wiki) for more instructions.

The software is provided under the Apache Licence.  Its copy is available from http://www.apache.org/licenses/LICENSE-2.0 .
Executable jar file contains following third party software libraries: GBIF API client Java code, Apache axis including jaxrpc, Jackson version 1, Google guava and Find Bugs.  These third party software libraries are copyrighted by the original authors. All but Find Bugs are licenced under the Apache Licence.  Find Bugs is licensed under  the Lesser GNU Public License, https://www.gnu.org/licenses/lgpl.html.
