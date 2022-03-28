(ns time-conversion
  (:import
   (java.time LocalTime)
   (java.time.format DateTimeFormatter)
   ))
;
; Complete the 'timeConversion' function below.
;
; The function is expected to return a STRING.
; The function accepts STRING s as parameter.
;

(defn timeConversion [s]
  (.format (LocalTime/parse s (DateTimeFormatter/ofPattern "hh:mm:ssa")) (DateTimeFormatter/ofPattern "HH:mm:ss"))
  )

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def s (read-line))

(def result (timeConversion s))

(spit fptr (str result "\n") :append true)

(comment
  (.format (LocalTime/parse "12:01:00PM" (DateTimeFormatter/ofPattern "hh:mm:ssa")) (DateTimeFormatter/ofPattern "HH:mm:ss"))
  )
