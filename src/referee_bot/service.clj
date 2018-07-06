(ns referee-bot.service
  (:require [referee-bot.data :refer [state]]))

(defn initialise-game []
  "returns an clean game state"
  {:players []})

(defn register-player [new-player]
  (swap! state (fn [s] (update s :players conj new-player))))
