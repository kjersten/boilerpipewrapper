(ns boilerpipewrapper.core
  (:gen-class
     :name net.bitzoo.BoilerpipeWrapper)
  (:import 
   	de.l3s.boilerpipe.extractors.ArticleExtractor
  	java.net.URL))

(defn -main
  "Just print a string"
  [& args]
  (if (or (nil? args) (not (.startsWith (first args) "http://"))) (println "Please provide a URL.")
   (println (.getText ArticleExtractor/INSTANCE (new URL (first args)))))
  )