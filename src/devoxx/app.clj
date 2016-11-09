(ns devoxx.app
  (:require [devoxx.domain :as domain]
            [devoxx.web :as web]
            [ring.adapter.jetty :refer [run-jetty]]))

(defn -main [& args]
  (domain/add-todo! {:text "Go to Devoxx"})
  (domain/add-todo! {:text "Upload example"})

  (run-jetty web/routes {:port 3000}))
