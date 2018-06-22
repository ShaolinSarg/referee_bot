(ns referee-bot.metrics-test
  (:require [referee-bot.metrics :as sut]
            [clojure.test :refer [deftest testing is]]))


(deftest metrics-tests
  (testing "counters increment correctly"
    (testing "register-player counter"
      (is (= 1 (sut/inc-registered-players!))))))
