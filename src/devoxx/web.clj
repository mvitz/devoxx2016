(ns devoxx.web
  (:require [compojure.core :refer [defroutes GET POST]]
            [devoxx.domain :as domain]
            [ring.util.response :refer [redirect]]))

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
               "<form method=\"post\" action=\"/\">"
                 "<input type=\"text\" name=\"text\"/>"
                 "<input type=\"submit\" value=\"Save\"/>"
               "</form>"
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

(defn add [todo]
  (redirect (str "/" (:id todo))))

(defroutes routes
  (GET "/" []
       (index (domain/get-todos)))
  (GET "/:id" [id]
       (when-let [todo (domain/get-todo (Integer/parseInt id))]
         (show todo)))
  (POST "/" request
        (when-let [text (get-in request [:params :text])]
          (add (domain/add-todo! {:text text})))))
