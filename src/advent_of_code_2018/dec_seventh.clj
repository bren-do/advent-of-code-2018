(ns advent-of-code-2018.dec-seventh
  (:require [clojure.java.io :as io]
            [clojure.set :refer [difference union intersection]]))

(def instructions-test-text
  "Step C must be finished before step A can begin.
  Step C must be finished before step F can begin.
  Step A must be finished before step B can begin.
  Step A must be finished before step D can begin.
  Step B must be finished before step E can begin.
  Step D must be finished before step E can begin.
  Step F must be finished before step E can begin.")

(def instructions-text
  (clojure.string/trim (slurp (io/resource "dec_seventh.txt"))))

(defn describe-dependencies
  [instructions]
  (reduce (fn [m [before after]]
            (-> m
                (update after (fnil #(conj % before) #{}))
                (update before (fnil #(clojure.set/union % #{}) #{})))) {} instructions))

(defn sort-deps
  [deps-graph]
  (sort-by first deps-graph))

(defn deps-satisfied?
  [s deps]
  (clojure.set/subset? deps (into #{} (map str s))))

(defn in-output?
  [output letter]
  (some #(= (str %) letter) output))

(defn add-next-letter
  [output instructions]
  (loop [next-letter nil instructions instructions]
    (if next-letter
      next-letter
      (let [[letter deps] (first instructions)]
        (recur (when (not (in-output? output letter))
                 (cond
                   (= (count deps) 0) letter
                   (deps-satisfied? output deps) letter)) (rest instructions))))))

(defn construct-string
  [instructions]
  (loop [output ""]
    (let [constructed-string (str output (add-next-letter output instructions))]
      (println (count constructed-string) (count instructions))
      (if (= (count constructed-string) (count instructions))
        constructed-string
        (recur constructed-string)))))

(defn parse-instruction
  [s]
  (re-seq #"\b\w\b" s))

(defn parse-instructions
  [text]
  (->> (clojure.string/split text #"\n")
       (map clojure.string/trim)
       (map parse-instruction)))

(defn part1
  [text]
  (->> text
       parse-instructions
       describe-dependencies
       sort-deps
       construct-string))
