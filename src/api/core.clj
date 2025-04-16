(ns api.core
  (:require [api.user-service :as user-service]
            [cheshire.core :as json])
  (:import (io.javalin Javalin))
  (:gen-class))

(defn build-response [ctx data]
  (.json ctx (json/generate-string data)))

(defn user-handler [ctx]
  (let [name (.pathParam ctx "username")]
    (build-response ctx (user-service/get-user name))))

(defn users-handler [ctx]
  (let [active (.queryParam ctx "active")]
    (build-response ctx (user-service/get-all-users (parse-boolean (or active "true"))))))

(defn start-server []
  (doto (Javalin/create)
    (.get "/hello" (fn [ctx] (.result ctx "Hello World!")))
    (.get "/users/{username}" user-handler)
    (.get "/users" users-handler)
    (.start 7000)))

(defn -main []
  (start-server))

