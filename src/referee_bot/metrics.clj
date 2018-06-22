(ns referee-bot.metrics
  (:require [metrics.core :refer [new-registry]]
            [metrics.counters :refer [defcounter inc! value]]
            [metrics.reporters.console :as console]))


(def metrics-registry (new-registry))


(defcounter metrics-registry players-registered)


(def CR (console/reporter metrics-registry {}))
(console/start CR 10)


(defn inc-registered-players! []
  (inc! players-registered))
