(ns pythagorean-triplet.core-test
  (:require [clojure.test :refer :all]
            [pythagorean-triplet.core :refer :all]))

(deftest pythagorean-triplet?3-4-5-true
 (testing "3^2 + 4^2 = 5^2"
    (is (pythagorean-triplet? 3 4 5))))


    ;(run-tests 'pythagorean-triplet.core-test)
