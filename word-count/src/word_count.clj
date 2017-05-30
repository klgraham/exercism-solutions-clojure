(ns word-count
  (require [clojure.string :as str]))

(defn update-counts [counter word]
  (update-in counter [word] (fnil inc 0)))

(defn word-count [phrase]
  ; simplest is using clojure.core's frequencies
  ;(-> (str/lower-case phrase)
  ;    (str/split #"[^A-Za-z0-9]+")
  ;    frequencies)
  (let [words (str/split (str/lower-case phrase) #"[^A-Za-z0-9]+")]
    (reduce update-counts {} words)))
