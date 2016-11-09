(ns devoxx.app
  (:require [devoxx.domain :as domain]))

(defn -main [& args]
  (domain/add-todo! {:text "Go to Devoxx"})
  (domain/add-todo! {:text "Upload example"})

  (println (domain/get-todos))
  (println (domain/get-todo 1))
  (println (domain/get-todo 3)))
