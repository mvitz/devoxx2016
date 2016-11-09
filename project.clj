(defproject devoxx "0.1.0-SNAPSHOT"
  :description "Devoxx 2016"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"
            :distribution :repo
            :comments "A business-friendly OSS license"
            :year 2016
            :key "mit"}
  :min-lein-version "2.0.0"
  :dependencies [[compojure "1.5.1"]
                 [hiccup "1.0.5"]
                 [org.clojure/clojure "1.8.0"]
                 [ring/ring-jetty-adapter "1.5.0"]]
  :main devoxx.app)
