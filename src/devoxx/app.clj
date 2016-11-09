(ns devoxx.app
  (:require [devoxx.domain :as domain]
            [devoxx.web :as web]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.middleware.params :refer [wrap-params]])
  (:gen-class))

(def app
  (-> web/routes
      wrap-keyword-params
      wrap-params))

(defn -main [& args]
  (domain/add-todo! {:text "Go to Devoxx"})
  (domain/add-todo! {:text "Upload example"})

  (run-jetty app {:port 3000}))
