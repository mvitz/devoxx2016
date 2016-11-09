(ns devoxx.web
  (:require [devoxx.domain :as domain]))

(defn index [request]
  {:body (str
           "<!DOCTYPE html>"
           "<html>"
             "<head>"
               "<title>Devoxx TODOs</title>"
             "</head>"
             "<body>"
               "<h1>Devoxx TODOs</h1>"
               "<ul>"
                 (clojure.string/join
                   (map #(str "<li>" (:text %) "</li>") (domain/get-todos)))
               "</ul>"
             "</body>"
           "</html>")})
