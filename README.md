# boilerpipewrapper

A Clojure library designed to wrap Boilerpipe, which is a Java library
that extracts text from the surrounding boilerplate on a website.
This project provides a command-line interface to access the boilerpipe functionality, for example from a Ruby on Rails project.

## Usage

First, you will need to wrap this into a executable jar file.  Navigate
to the project's base directory and type:
>lein uberjar

In order to execute the jar, use this command: 
> java -cp boilerpipewrapper-0.2.0-SNAPSHOT-standalone.jar net.bitzoo.BoilerpipeWrapper http://www.example.com

Optionally, you can also specify the name of the extractor to use, e.g. KeepEverythingExtractor.

If you don't specify an extractor, the ArticleExtractor will be used.

The different types of extractors are described on the Boilerpipe Web API page:
http://boilerpipe-web.appspot.com/

## License

Distributed under the Eclipse Public License, the same as Clojure.
