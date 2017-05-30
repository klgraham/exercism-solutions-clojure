(ns rna-transcription
  (:require [clojure.string :as str]))

(def base-pair-mapping {"G" "C"
                        "C" "G"
                        "T" "A"
                        "A" "U"})

(defn dna->rna [base]
  (let [transcribed-base (get base-pair-mapping base)]
    (if (nil? transcribed-base)
      (throw (AssertionError. "Invalid DNA strand!"))
      transcribed-base)))


(defn to-rna [dna]
  (let [dna-seq (str/split dna #"")]
    (apply str (map dna->rna dna-seq))))
