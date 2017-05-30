(ns anagram
  (:require [clojure.string :as str]))

(defn anagrams-for [word possible-anagrams]
  (let [lowercased-word (str/lower-case word)
        sorted-chars (sort lowercased-word)
        matches (->> possible-anagrams
                     (map #(vector % (= (sort (str/lower-case %)) sorted-chars)))
                     (filter #(and (second %) (not= (first %) lowercased-word))))]
    (if (empty? matches)
      []
      (map first matches))))