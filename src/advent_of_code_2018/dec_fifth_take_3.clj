(ns advent-of-code-2018.dec-fifth-take-3)

(def test-input
  (seq "dabAcCaCBAcCcaDA"))

(def real-input
  (seq (clojure.string/trim (slurp (clojure.java.io/resource "dec_fifth.txt")))))

(defn reactable?
  [a b]
  (let [a-int-val (int a)
        b-int-val (int b)]
    (= 32 (Math/abs (- a-int-val b-int-val)))))


(defn react
  [letters]
  (loop [f [] letters letters]
    (if (< (count letters) 2)
      (concat f letters)
      (let [fl (first letters)
            sl (second letters)]
        (if (reactable? fl sl)
          (recur f (drop 2 letters))
          (recur (conj f fl) (rest letters)))))))


(defn part1
  [input]
  (loop [unreacted input]
    (let [reacted (react unreacted)]
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
