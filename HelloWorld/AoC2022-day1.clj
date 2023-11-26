(ns advent-2022-clojure.day01
  (:require [clojure.string :as str]))


(defn read-file [file-path]
   (slurp file-path))                                    ;; Read the .txt file into a string

(defn parse-calories [input-string]
  (apply max                                             ;; Find elf with max calories
         (map #(reduce + (map read-string %))            ;; Sum each eleve's calories
              (map #(str/split % #"\n")                  ;; Split input string by new lines
                   (str/split input-string #"\n\n+"))))) ;; Split input string by empty lines

(def elves-list (read-file "day01-puzzle.txt"))
(def solution (parse-calories elves-list))

(def message (format "The largest amount of calories carried by an elf is: %d" solution))
(println message)

