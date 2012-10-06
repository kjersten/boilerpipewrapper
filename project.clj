(defproject boilerpipewrapper "0.1.0-SNAPSHOT"
  :description "a CLI wrapper for the Java Boilerpipe library"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [de.l3s.boilerpipe/boilerpipe "1.1.0"]
		 		 [nekohtml "1.9.6.2"] ;; boilerpipe fails to declare this dependency
                 [xerces/xercesImpl "2.8.1"] ;; this version of xerces is required by nekohtml
                ]
  :main boilerpipewrapper.core)