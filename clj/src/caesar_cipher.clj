(ns caesar-cipher)
;
; Complete the 'caesarCipher' function below.
;
; The function is expected to return a STRING.
; The function accepts following parameters:
;  1. STRING s
;  2. INTEGER k
;

(defn shift [c k begin-char-code end-char-code]
  (let [code (+ (int c) (mod k (+ 1 (- end-char-code begin-char-code))))
        shifted-code (if (< end-char-code code)
                       (+ begin-char-code (- code end-char-code 1))
                       code)]
    (char shifted-code))
  )

(defn caesarCipher [s k]
  (apply str (map (fn [c]
                    (cond
                      (re-matches #"[a-z]" (str c)) (shift c k (int \a) (int \z))
                      (re-matches #"[A-Z]" (str c)) (shift c k (int \A) (int \Z))
                      :else c
                      )) s))
)

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def s (read-line))

(def k (Integer/parseInt (clojure.string/trim (read-line))))

(def result (caesarCipher s k))

(spit fptr (str result "\n") :append true)

(comment
  (shift \w 87 (int \a) (int \z))
  (mod 87 (+ (- (int \z) (int \a)) 1))
  (caesarCipher "www.abc.xy" 87)
  (char (+ (int \a) 3))
  )
