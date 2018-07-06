(ns referee-bot.data)

(def state (atom {:players []}))

(defrecord Player [username uri])
