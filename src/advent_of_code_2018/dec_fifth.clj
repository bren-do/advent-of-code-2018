(ns advent-of-code-2018.dec-fifth)

(def test-input
  (seq "dabAcCaCBAcCcaDA"))

(def real-input
  (seq (slurp (clojure.java.io/resource "dec_fifth.txt"))))

(defn split-into-chunks
  [test-input]
  (->> test-input
       (partition-by (comp  clojure.string/upper-case str))))

(defn react
  [letters]
  (loop [f [] letters letters]
    (if (< (count letters) 2)
      (concat f letters)
      (if-let [head (when (= (first letters) (second letters))
                      (take 2 letters))]
        (recur (concat f [(first letters)]) (rest letters))
        (recur f (drop 2 letters))))))


(defn part1
  [input]
  (loop [unreacted input]
    (let [chunks (split-into-chunks unreacted)
          reacted (flatten (map react chunks))]
      (if (= (count reacted) (count unreacted))
        (count reacted)
        (recur reacted)))))


(defn part2
  ([]
   (part2 real-input))
  ([input]
   "Wait like 2 minutes"
   (map (fn [unit]
          (->> input
               (remove #(#{unit (char (- (int unit) 32))} %))
               part1)) (take 2 (seq "abcdefghijklmnopqrstuvwxyz")))))
