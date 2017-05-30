(ns beer-song
  (:use [clojure.string :only (join)]))

(defn- first-line [n]
  (case n
    0 "No more bottles of beer on the wall, no more bottles of beer.\n"
    1 "1 bottle of beer on the wall, 1 bottle of beer.\n"
    (str n " bottles of beer on the wall, " n " bottles of beer.\n")))


(defn- second-line [n]
  (case n
    0 "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
    1 "Take it down and pass it around, no more bottles of beer on the wall.\n"
    2 "Take one down and pass it around, 1 bottle of beer on the wall.\n"
    (str "Take one down and pass it around, " (dec n) " bottles of beer on the wall.\n")))


(defn verse [n]
  (str (first-line n) (second-line n)))


(defn- join-verses [verse-indices]
  (->> verse-indices
       (map verse)
       (join "\n")))


(defn sing
  ([start] (sing start 0))
  ([start end] (join-verses (range start (dec end) -1))))
