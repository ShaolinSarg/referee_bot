(ns referee-bot.service-test
  (:require [clojure.test :refer [testing deftest is]]
            [referee-bot.service :as sut]
            [referee-bot.data :as data]))

(deftest service-tests
  (testing "reset-game"
    (testing "should return a new game state"
      (is (= [] (:players (sut/initialise-game))))))

  (testing "register-player"
    (testing "should persist a player"
      (let [bot (data/->Player "bot1" "http://...1")]
        (is (= "bot1" (do (sut/register-player bot)
                          (get-in @data/state [:players 0 :username]))))
        (is (= "http://...1" (get-in @data/state [:players 0 :uri])))))))
