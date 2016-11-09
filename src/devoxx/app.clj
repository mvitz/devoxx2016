(ns devoxx.app
  (:require [devoxx.domain :as domain]))

(defn -main [& args]
  (println (domain/get-todos)))
