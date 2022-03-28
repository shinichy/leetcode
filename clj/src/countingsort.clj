(ns countingsort)
;
; Complete the 'countingSort' function below.
;
; The function is expected to return an INTEGER_ARRAY.
; The function accepts INTEGER_ARRAY arr as parameter.
;

(defn countingSort [arr]
  (reduce (fn [acc v]
                          (assoc acc v (+ (nth acc v) 1))) (vec (make-array Integer/TYPE 100)) arr)
  )

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

(def result (countingSort arr))

(spit fptr (clojure.string/join " " result) :append true)
(spit fptr "\n" :append true)

(comment
  (def arr [1 1 3 2 1])
  (type (vec (make-array Integer/TYPE 100)))
  (assoc (vec (make-array Integer/TYPE 100)) 10 1)
  (def frequency-arr (reduce (fn [acc v]
                               (assoc acc v (+ (nth acc v) 1))) (vec (make-array Integer/TYPE 100)) arr))
  (mapcat (fn [i]
         (repeat (nth frequency-arr i) i)) (range (count frequency-arr)))
  )
