(defproject devoxx "0.1.0-SNAPSHOT"
  :description "Devoxx 2016"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"
            :distribution :repo
            :comments "A business-friendly OSS license"}
  :min-lein-version "2.0.0"
  :dependencies [[compojure "1.5.1"]
                 [org.clojure/clojure "1.8.0"]
                 [ring/ring-jetty-adapter "1.5.0"]]
  :main devoxx.app)
