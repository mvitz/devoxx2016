(ns devoxx.domain)

(def id (atom 0))
(def todos (atom []))

(defn- next-id []
  (swap! id inc))

(defn get-todos []
  @todos)

(defn add-todo! [item]
  (let [id (next-id)
        item-with-id (assoc item :id id)]
    (swap! todos conj item-with-id)))
