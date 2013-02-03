(ns boilerpipewrapper.core
  (:gen-class
     :name net.bitzoo.BoilerpipeWrapper)
  (:import 
   	(de.l3s.boilerpipe.extractors ArticleExtractor DefaultExtractor LargestContentExtractor KeepEverythingExtractor CanolaExtractor)
  	java.net.URL
    java.io.InputStream
    org.xml.sax.InputSource))

(def extractors {:ArticleExtractor (ArticleExtractor/INSTANCE)
     	      :DefaultExtractor (DefaultExtractor/INSTANCE)
	      :LargestContentExtractor (LargestContentExtractor/INSTANCE)
	      :KeepEverythingExtractor (KeepEverythingExtractor/INSTANCE)
	      :CanolaExtractor (CanolaExtractor/INSTANCE)})

(defn -main
  "Accepts a URL, parses the main content from that page and prints it to STDOUT"
  [& args]
  (let [url (first args) 
        extractor-arg (second args)
        extractor-name (if (and extractor-arg ((keyword extractor-arg) extractors)) extractor-arg "ArticleExtractor")
	extractor-instance  ((keyword extractor-name) extractors)]
    ;; (println (new InputSource (.openStream (new URL url))))
    (if (not (.startsWith url "http://")) 
      (println "Please provide a URL.")
      (println (.getText extractor-instance (new InputSource (.openStream (new URL url)))))
    )
    )
  )  