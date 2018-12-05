(ns advent-of-code-2018.dec-fifth)

(def test-input
  (seq "dabAcCaCBAcCcaDA"))

(def real-input
  (seq (clojure.string/trim (slurp (clojure.java.io/resource "dec_fifth.txt")))))

(def split-into-chunks
  (partition-by #(let [int-val (int %)]
                   (if (< int-val 96)
                     (+ int-val 32)
                     int-val))))

(defn react
  [letters]
  (loop [f [] letters letters]
    (if (< (count letters) 2)
      (concat f letters)
      (if (= (first letters) (second letters))
        (recur (conj f (first letters)) (rest letters))
        (recur f (drop 2 letters))))))


(defn part1
  [input]
  (loop [unreacted input]
    (let [reacted (sequence (comp split-into-chunks
                                  (map react)
                                  (mapcat identity)) unreacted)]
      (if (= (count reacted) (count unreacted))
        (count reacted)
        (recur reacted)))))


(defn part2
  ([]
   (part2 real-input))
  ([input]
   "Wait like 13 minutes"
   (apply min (map (fn [unit]
                     (->> input
                          (remove #(#{unit (char (- (int unit) 32))} %))
                          part1)) (seq "abcdefghijklmnopqrstuvwxyz")))))
