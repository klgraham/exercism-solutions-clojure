(ns bob)

(defn response-for [s]
  (let [ends-in-? (= (last s) \?)
        all-caps? (= (clojure.string/upper-case s) s)
        has-no-letters? (empty? (filter #(Character/isLetter %) s))]
    (cond
      (every? #(Character/isWhitespace %) s) "Fine. Be that way!"
      (and all-caps? (not has-no-letters?)) "Whoa, chill out!"
      ends-in-? "Sure."
      :else "Whatever.")))
