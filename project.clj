(defproject referee_bot "0.1.0-SNAPSHOT"

  :description "A server to decide which player wins a hand of rock paper scissors"

  :url "https://github.com/ShaolinSarg/referee_bot"

  :min-lein-version "2.0.0"

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.4.0"]
                 [com.taoensso/timbre "4.10.0"]
                 [metrics-clojure "2.10.0"]
                 [metrics-clojure-ring "2.10.0"]
                 [cheshire "5.8.0"]
                 [clj-http "3.9.0"]]

  :plugins [[lein-ring "0.12.4"]]

  :ring {:handler referee-bot.web/app}

  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.2"]
                                  [clj-http-fake "1.0.3"]]}})
