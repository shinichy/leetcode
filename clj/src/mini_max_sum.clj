(ns mini-max-sum)
;
; Complete the 'miniMaxSum' function below.
;
; The function accepts INTEGER_ARRAY arr as parameter.
;

(defn miniMaxSum [arr]
  (let [{:keys [min max total]} (reduce (fn [acc v]
                                          (cond-> acc
                                            (< v (get acc :min Integer/MAX_VALUE)) (assoc :min v)
                                            (< (get acc :max Integer/MIN_VALUE) v) (assoc :max v)
                                            true (assoc :total (+ v (get acc :total)))
                                            )
                                          ) {:total 0} arr)
        min-sum (- total max)
        max-sum (- total min)]
    (println (format "%d %d" min-sum max-sum)))
  )

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

(miniMaxSum arr)

(comment
  (def arr [3 1 5 7 9])
  (let [{:keys [min max total]} (reduce (fn [acc v]
                                          (cond-> acc
                                            (< v (get acc :min Integer/MAX_VALUE)) (assoc :min v)
                                            (< (get acc :max Integer/MIN_VALUE) v) (assoc :max v)
                                            true (assoc :total (+ v (get acc :total)))
                                            )
                                          ) {:total 0} arr)
        min-sum (- total max)
        max-sum (- total min)]
    (println (format "%d %d" min-sum max-sum)))
  )
