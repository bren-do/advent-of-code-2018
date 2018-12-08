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

(defn next-letter?
  [output letter deps]
  (and (not (in-output? output letter))
       (deps-satisfied? output deps)))

(defn get-next-letter
  [output instructions]
  (loop [next-letter nil instructions instructions]
    (if next-letter
      next-letter
      (let [[letter deps] (first instructions)]
        (recur (when (next-letter? output letter deps) letter) (rest instructions))))))

(defn construct-string
  [instructions]
  (loop [output ""]
    (let [constructed-string (str output (get-next-letter output instructions))]
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


(def task-length
  (apply merge (map (fn [letter length]
                      {(str letter) length}) "ABCDEFGHIJKLMNOPQRSTUVWXYZ" (range 1 (+ 1 26)))))

(defn get-busy-workers
  [workers]
  (filter #(< 0 (second %)) workers))

(defn get-finished-task
  []
  (println "GET-FINISHED-TASK NOT IMPLEMENTED"))

(defn update-busy-workers-state
  [output worker]
  (println "UPDATE-BUSY-WORKERS-STATE NOT IMPLEMENTED")
  #_(if-let [letter (get-finished-task worker)]
      (update )))

(defn being-worked-on?
  [workers [letter deps]]
  (println workers letter deps)
  (filter (fn [[l d]]
            (= l letter)) workers))


(defn add-new-task
  [task worker]
  {task (get task-length task)})

(defn get-available-tasks
  [output workers dependency-graph]
  (->> (filter (fn [[letter deps]] (next-letter? output letter deps)) dependency-graph)
       (remove #(being-worked-on? workers %))
       (map first)))

(defn get-idle-workers
  [workers]
  (println "GET-IDLE-WORKERS NOT IMPLEMENTED"))

(defn work
  [dependency-graph workers]
  (loop [second 0 workers workers output ""]
    (let [tasks (get-available-tasks output workers dependency-graph)
                                        ;idle-workers (get-idle-workers workers)
                                        ;newly-tasked-workers (map add-new-task tasks idle-workers)
                                        ;busy-workers (get-busy-workers workers)
                                        ;[output updated-workers] (reduce #(update-busy-workers-state % output %2) {} busy-workers)
          ]
                                        ;[(inc second) output (concat newly-tasked-workers updated-workers)]
      tasks
      )))


(defn part2
  [text]
  (-> text
      parse-instructions
      describe-dependencies
      sort-deps
      (work [["D" 3] ["E" 4]])))
