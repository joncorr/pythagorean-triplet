(ns pythagorean-triplet.core
  (:gen-class))



(defn pythagorean-triplet? [a b c]
  (let [asqr (* a a)
        bsqr (* b b)
        csqr (* c c)]
        (= (+ asqr bsqr) csqr)))

 (defn gen-triple [n m]
  (let [m-sqr (* m m)
        n-sqr (* n n)
        a (- m-sqr n-sqr)
        b (* 2 m n)
        c (+ m-sqr n-sqr)]
        [a b c]))

(defn find-triplet-whose-sum-is [sum seed-triplet]
  (loop [triplet seed-triplet scalar 1]
        (let [[a b c] (map (partial * scalar) triplet)
              sum-triplet (+ a b c)]
           (prn [a b c] sum-triplet (pythagorean-triplet? a b c))
          (if (> sum-triplet sum)
            "not found"
            (if (= (+ a b c) 1000)
              triplet
              (recur [a b c] (inc scalar)))))))

(defn -main
  [& args]
  (def limit 2000)
  (for [m (range 2 limit)
        n (range 1 limit)
        :let [[a b c] (gen-triple n m)]
        :when (and (< n m) (= (+ a b c) 1000))]
          (prn (str "The triplet is " [a b c]
               " and the product is " (reduce * [a b c])))))
