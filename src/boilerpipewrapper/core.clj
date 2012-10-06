(ns boilerpipewrapper.core
  (:gen-class
     :name net.bitzoo.BoilerpipeWrapper)
  (:import 
   	de.l3s.boilerpipe.extractors.ArticleExtractor
  	java.net.URL
    java.io.InputStream
    org.xml.sax.InputSource))

(def parser-options '("ArticleExtractor" "DefaultExtractor" "LargestContentExtractor"
                      "KeepEverythingExtractor" "CanolaExtractor"))

(defn -main
  "Accepts a URL, parses the main content from that page and prints it to STDOUT"
  [& args]
  (let [url (first args) 
        extractor-arg (second args)
        extractor (if (and extractor-arg (some #{extractor-arg} parser-options)) extractor-arg "ArticleExtractor")] 
	(println parser-options)
    (println (if (nil? extractor) "here is where the extractor string would go" extractor))
    (if (not (.startsWith url "http://")) 
      (println "Please provide a URL.")
      (println (class extractor))
      ;; (println (doto (extractor .INSTANCE) (.getText (new InputSource (.openStream (new URL url))))))
       ;;(.getText extractor/INSTANCE (new InputSource (.openStream (new URL url))))))
	)
   )
  )