(defproject clojure_webapp "1.0.0-SNAPSHOT"
  :description "Netweaver Cloud Persistence Example"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [ring/ring-core "1.1.1"]
 		         [ring/ring-jetty-adapter "1.0.2"]
; 		         [org.apache.derby/derby "10.8.1.2"]
 		         [hiccup "1.0.0"]
 		         [compojure "1.1.0"]]
  :plugins [[lein-ring "0.7.1"]]
  :ring {:handler clojure_webapp.core/app-setup
  	     :web-xml "web.xml"})