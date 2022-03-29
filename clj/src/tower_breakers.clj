(ns tower-breakers)
;
; Complete the 'towerBreakers' function below.
;
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER n
;  2. INTEGER m
;

(defn towerBreakers [n m]
  (if (or (= 0 (mod n 2)) (= 1 m))
    2
    1)
  )

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def t (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [t-itr (range t)]
    (def first-multiple-input (clojure.string/split (clojure.string/trimr (read-line)) #" "))

    (def n (Integer/parseInt (nth first-multiple-input 0)))

    (def m (Integer/parseInt (nth first-multiple-input 1)))

    (def result (towerBreakers n m))

    (spit fptr (str result "\n") :append true)
)

(comment
  (= 1 (mod 2 2))
  (towerBreakers 2 2)
  )
