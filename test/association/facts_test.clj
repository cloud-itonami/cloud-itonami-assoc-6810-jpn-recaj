(ns association.facts-test
  (:require [clojure.test :refer [deftest is]]
            [association.facts :as facts]))

(deftest recaj-has-spec-basis
  (let [sb (facts/spec-basis "recaj")]
    (is (= 2 (count sb)))
    (is (every? #(= "6810" (:association-rule/isic %)) sb))
    (is (every? #(= "JPN" (:association-rule/country %)) sb))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "keidanren")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["recaj" "keidanren"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["keidanren"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= ["recaj.voluntary-action-plan-fair-transactions"]
         (mapv :association-rule/id (facts/by-topic "recaj" :fair-transaction))))
  (is (empty? (facts/by-topic "recaj" :labor)))
  (is (empty? (facts/by-topic "keidanren" :governance))))
