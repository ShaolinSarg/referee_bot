(ns referee-bot.web-test
  (:require [referee-bot.web :as sut]
            [clojure.test :refer [deftest is testing are]]
            [ring.mock.request :as mock]))

(deftest routes-tests
  (testing "endpoints"
    (testing "return the right http status"
      (are [expected actual] (= (:status actual) expected)
        200 (sut/app (mock/request :get "/"))
        200 (sut/app (mock/request :get "/players"))
        201 (sut/app (-> (mock/request :post "/players")
                         (mock/json-body {:name "rockly" :url "http://..."})))))

    (testing "return the correct created link"
      (are [expected actual] (= (get-in actual [:headers "Location"]) expected)
        "http://localhost/players/rockly" (sut/app (-> (mock/request :post "/players")
                                                       (mock/json-body {:name "rockly" :url "http://..."})))
        "http://localhost/players/paperly" (sut/app (-> (mock/request :post "/players")
                                                        (mock/json-body {:name "paperly" :url "http://..."}))))
      )

    (testing "return the right content type"
      (is (= "application/json"
             (get-in (sut/app (mock/request :get "/players")) [:headers "Content-Type"]))))))
