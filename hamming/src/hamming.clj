(ns hamming)

(defn distance [seq1 seq2]
  (if (= (count seq1) (count seq2))
    (reduce + (map #(if (= %1 %2) 0 1) seq1 seq2))))

