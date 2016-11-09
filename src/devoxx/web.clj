(ns devoxx.web
  (:require [compojure.coercions :refer [as-int]]
            [compojure.core :refer [defroutes GET POST]]
            [devoxx.domain :as domain]
            [hiccup.element :refer (link-to)]
            [hiccup.form :as f]
            [hiccup.page :refer [html5]]
            [ring.util.response :refer [redirect]]))

(defn index [todos]
  (html5
    [:head
     [:title "Devoxx TODOs"]]
    [:body
     [:h1 "Devoxx TODOs"]
     [:ul
      (map #(vector :li (link-to (str "/" (:id %)) (:text %))) todos)]
     (f/form-to [:post "/"]
                (f/text-field "text")
                (f/submit-button "Add"))]))

(defn show [todo]
  (html5
    [:head
     [:title (str "Devoxx TODO: " (:text todo))]]
    [:body
     [:h1 "Devoxx TODO"]
     [:h2 (:text todo)]
     (link-to "/" "Back")]))

(defn add [todo]
  (redirect (str "/" (:id todo))))

(defroutes routes
  (GET "/" []
       (index (domain/get-todos)))
  (GET "/:id" [id :<< as-int]
       (when-let [todo (domain/get-todo id)]
         (show todo)))
  (POST "/" request
        (when-let [text (get-in request [:params :text])]
          (add (domain/add-todo! {:text text})))))
