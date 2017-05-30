(ns hello-world)

(defn hello [& x]
  (if-let [name (first x)]
    (str "Hello, " name "!")
    (str "Hello, World!")))
