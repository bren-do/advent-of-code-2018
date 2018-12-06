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
                    (inc (second (:coordinates points)))) input)))

(defn get-board-width
  [input]
  (apply max (map (fn [points]
                    (inc (first (:coordinates points)))) input)))

(defn make-blank-board
  [input]
  (repeat (get-board-height input) (repeat (get-board-width input) nil)))

(defn calculate-manhattan-distance
  [j i {:keys [name coordinates] :as points}]
  (let [x (first coordinates)
        y (second coordinates)]
    {:name name
     :distance (+ (Math/abs (- i x))
                  (Math/abs (- j y)))}))

(defn fill-in-cell
  [points j i]
  (let [distances (sort-by :distance (map (partial calculate-manhattan-distance j i) points))
        [a b] (take 2 distances)]
    (cond
      (= (:distance a) (:distance b)) \.
      :else (:name a))))

(defn fill-in-areas
  [points]
  (let [board (make-blank-board points)]
    (map (fn [row j]
           (map (partial fill-in-cell points j) (range (count row))))
         board (range (count board)))))

(defn determine-biggest-area-for-row
  [row j]
  (let [fi (first row)
        li (last row)]
    (merge-with +
                {fi Double/POSITIVE_INFINITY}
                {li Double/POSITIVE_INFINITY}
                (reduce (fn [coll name]
                          (if (= name \.)
                            coll
                            (if (= j 0)
                              (assoc coll name Double/POSITIVE_INFINITY)
                              (update coll name (fnil inc 0))))) {} (drop-last 1 (drop 1 row))))))

(defn determine-biggest-area
  [board]
  (apply merge-with + (map determine-biggest-area-for-row board (range (count board)))))



(defn part1
  [data]
  (->> data
       process-data
       fill-in-areas
       determine-biggest-area
       (sort-by second)
       reverse
       (remove #(= ##Inf (second %)))))
