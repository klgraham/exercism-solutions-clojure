(ns phone-number
  (:use [clojure.string :only (join)]))


(defn- is-invalid? [digits]
  (let [num-digits (count digits)]
    (or (and (= 11 num-digits) (not= \1 (first digits)))
         (= 9 num-digits))))


(defn number [phone-number]
  (assert (string? phone-number))
  (let [digits (join (filter #(Character/isDigit %) phone-number))]
    (cond
      (is-invalid? digits) "0000000000"
      (= 11 (count digits)) (subs digits 1)
      :else digits)))


(defn area-code [phone-number]
  (subs (number phone-number) 0 3))


(defn pretty-print [phone-number]
  (let [digits (number phone-number)
        exchange (subs digits 3 6)
        subscriber (subs digits 6 10)]
    (str "(" (area-code digits) ") " exchange "-" subscriber)))