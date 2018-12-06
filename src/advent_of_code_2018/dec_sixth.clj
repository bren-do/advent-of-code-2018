(ns advent-of-code.dev-sixth)

(defn process-data
  [input]
  (let [coordinates (sequence (comp (map (fn [s] (clojure.string/split s #", ")))
                                    (map (fn [x]
                                           (mapv read-string x))))
                              (clojure.string/split input #"\n"))]
    (map (fn [name xy]
           {:name name
            :coordinates xy}) (range (count coordinates)) coordinates)))

(def test-data
  "1, 1
  1, 6
  8, 3
  3, 4
  5, 5
  8, 9")

(def real-data
  (clojure.string/trim (slurp (clojure.java.io/resource "dec_sixth.txt"))))

(defn get-board-height
  [input]
  (apply max (map (fn [points]
                    (second (:coordinates points))) input)))

(defn get-board-width
  [input]
  (apply max (map (fn [points]
                    (first (:coordinates points))) input)))

(defn make-blank-board
  [input]
  (repeat (get-board-height input) (repeat (get-board-width input) nil)))

(defn fill-in-cell
  [points i j]
  "O")

(defn fill-in-areas
  [points]
  (let [board (make-blank-board points)]
    (map (fn [row i]
           (map (partial fill-in-cell points i) (range (count row))))
         board (range (count board)))))
