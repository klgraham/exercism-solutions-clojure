(ns nucleotide-count
  (:use [clojure.string :only (split)]))


(def dna-bases #{\G \C \T \A})

(defn- update-counts [counter base]
  (assert (contains? dna-bases base) (str "Invalid base (" base ") in DNA strand."))
  (update-in counter [base] (fnil inc 0)))


(defn nucleotide-counts [dna]
  (let [bases (seq dna)]
    (reduce update-counts {\A 0, \T 0, \C 0, \G 0} bases)))


(defn count [base dna]
  (assert (contains? dna-bases base) (str base " is not a valid nucleotide for DNA."))
  (get (nucleotide-counts dna) base))