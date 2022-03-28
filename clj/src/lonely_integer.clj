(ns lonely-integer)
;
; Complete the 'lonelyinteger' function below.
;
; The function is expected to return an INTEGER.
; The function accepts INTEGER_ARRAY a as parameter.
;

(defn lonelyinteger [a]
  (first (:unique (reduce (fn [{:keys [appeared unique] :as acc} v]
                            (if (contains? appeared v)
                              (assoc acc :unique (disj unique v))
                              (assoc acc
                                     :unique (conj unique v)
                                     :appeared (conj appeared v)))) {:appeared #{} :unique #{}} a)))
  )

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def a (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

(def result (lonelyinteger a))

(spit fptr (str result "\n") :append true)

(comment
  (def a [1 2 3 4 3 2 1])
  (first (:unique (reduce (fn [{:keys [appeared unique] :as acc} v]
                            (if (contains? appeared v)
                              (assoc acc :unique (disj unique v))
                              (assoc acc
                                     :unique (conj unique v)
                                     :appeared (conj appeared v)))) {:appeared #{} :unique #{}} a)))
  )
