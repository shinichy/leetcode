(ns diagonal-difference)
;
; Complete the 'diagonalDifference' function below.
;
; The function is expected to return an INTEGER.
; The function accepts 2D_INTEGER_ARRAY arr as parameter.
;

(defn diagonalDifference [arr]
  (let [n (count arr)
        left-to-right (reduce + (map (fn [i]
                                       (nth (nth arr i) i)
                                       ) (range n)))
        right-to-left (reduce + (map (fn [i]
                                       (nth (nth arr i) (- n i 1))
                                       ) (range n)))]
    (Math/abs (- left-to-right right-to-left)))
  )

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def arr [])

(doseq [_ (range n)]
    (def arr (conj arr (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" ")))))
)

(def result (diagonalDifference arr))

(spit fptr (str result "\n") :append true)

(comment
  (def arr [[1 2 3]
            [4 5 6]
            [9 8 9]])
  (def n (count arr))
  (def left-to-right (reduce + (map (fn [i]
                                      (nth (nth arr i) i)
                                      ) (range n))))
  (def right-to-left (reduce + (map (fn [i]
                                      (nth (nth arr i) (- n i 1))
                                      ) (range n))))
  (diagonalDifference arr)
  )
