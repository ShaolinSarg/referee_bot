(ns referee-bot.web
  (:require [cheshire.core :as json]
            [compojure.core :refer [defroutes GET POST]]
            [compojure.route :refer [not-found resources]]
            [ring.middleware.defaults :refer [api-defaults wrap-defaults]]
            [ring.util.response :refer [content-type created response]]
            [ring.middleware.json :refer [wrap-json-body]]
            [taoensso.timbre :refer [debug info]]))


(defn- register-player
  [request]
  (let [player-name (get-in request [:body "name"])]
    (info (str "Registering Player: " player-name))
    (created (str "/players/" player-name))))


(defn- players
  []
  (info "Getting all players")
  (content-type (response (json/generate-string [{:name "Rockly" :url "http://..."}]))
                                   "application/json"))

(defroutes app-routes
  (GET "/"          []      "flom tom woo")
  (GET "/players"   []      (players))
  (POST "/players"  request (register-player request))

  (resources "/")
  (not-found "Not Found"))


(def app
  (-> app-routes
      wrap-json-body
      (wrap-defaults api-defaults)))
