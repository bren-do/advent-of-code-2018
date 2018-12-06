(ns advent-of-code-2018.dec-fifth-redux)

(def test-input
  (seq "dabAcCaCBAcCcaDA"))

(def real-input
  (seq (clojure.string/trim (slurp (clojure.java.io/resource "dec_fifth.txt")))))

(defn equal-case-insensitive?
  [a b]
  (let [a-int-val (int a)
        a-lower-case (if (< a-int-val 96)
                       (+ a-int-val 32)
                       a-int-val)
        b-int-val (int b)
        b-lower-case (if (< b-int-val 96)
                       (+ b-int-val 32)
                       b-int-val)]
    (= a-lower-case b-lower-case)))

(defn react
  [input]
  (loop [f (lazy-seq) letters input]
    (if (< (count letters) 2)
      (concat f letters)
      (let [[a b] (take 2 letters)]
        (if (and (not= a b)
                 (equal-case-insensitive? a b))
          (recur f (drop 2 letters))
          (recur (conj f a) (drop 1 letters)))))))

(defn part1
  [input]
  (loop [unreacted input]
    (let [reacted (react unreacted)]
      (if (= (count reacted) (count unreacted))
        (count reacted)
        (recur reacted)))))
