(ns devoxx.web
  (:require [compojure.core :refer [defroutes GET]]
            [devoxx.domain :as domain]))

(defn index [todos]
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
                   (map #(str
                           "<li>"
                             "<a href=\"/" (:id %) "\">"
                               (:text %)
                             "</a>"
                           "</li>") todos))
               "</ul>"
             "</body>"
           "</html>")})

(defn show [todo]
  {:body (str
           "<!DOCTYPE html>"
           "<html>"
             "<head>"
               "<title>Devoxx TODO: " (:text todo) "</title>"
             "</head>"
             "<body>"
               "<h1>Devoxx TODO</h1>"
               "<h2>" (:text todo) "</h2>"
               "<a href=\"/\">Back</a>"
             "</body>"
           "</html>")})

(defroutes routes
  (GET "/" []
       (index (domain/get-todos)))
  (GET "/:id" [id]
       (when-let [todo (domain/get-todo (Integer/parseInt id))]
         (show todo))))
