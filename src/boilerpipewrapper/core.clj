(ns boilerpipewrapper.core
  (:gen-class
     :name net.bitzoo.BoilerpipeWrapper)
  (:import 
   	de.l3s.boilerpipe.extractors.ArticleExtractor
  	java.net.URL
    java.io.InputStream
    org.xml.sax.InputSource))

(defn -main
  "Accepts a URL, parses the main content from that page and prints it to STDOUT"
  [& args]
  (if (or (nil? args) (not (.startsWith (first args) "http://"))) (println "Please provide a URL.")
   (println (.getText ArticleExtractor/INSTANCE 
     (new InputSource (.openStream (new URL (first args)))))))
  )