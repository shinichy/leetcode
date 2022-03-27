;
; Complete the 'plusMinus' function below.
;
; The function accepts INTEGER_ARRAY arr as parameter.
;
(ns plus-minus)

(comment
  (->label 1)
  (->label 0)
  (->label -1)
  (def arr [1 -2 -7 9 1 -8 -5])
  (plusMinus arr)
  (def n (count arr))
  (def grouped (group-by ->label arr))
  (def updated-grouped (cond-> grouped
                         (not (contains? grouped :pos)) (assoc :pos [])
                         (not (contains? grouped :neg)) (assoc :neg [])
                         (not (contains? grouped :zero)) (assoc :zero [])))
  (update-vals grouped (fn [arr]
                         (format "%.6f" (with-precision 6 (bigdec (/ (count arr) n)))))))

(defn update-vals [m f]
  (into {} (for [[k v] m] [k (f v)])))

(defn ->label [x]
  (cond
    (< 0 x) :pos
    (< x 0) :neg
    (= 0 x) :zero))

(defn plusMinus [arr]
  (let [grouped (group-by ->label arr)
        updated-grouped (cond-> grouped
                          (not (contains? grouped :pos)) (assoc :pos [])
                          (not (contains? grouped :neg)) (assoc :neg [])
                          (not (contains? grouped :zero)) (assoc :zero []))
        n (count arr)
        result (update-vals updated-grouped (fn [sub-arr]
                                              (format "%.6f" (with-precision 6 (bigdec (/ (count sub-arr) n))))))]
    (println (:pos result))
    (println (:neg result))
    (println (:zero result))))

(def n (Integer/parseInt (clojure.string/trim (read-line))))
(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))
(plusMinus arr)
