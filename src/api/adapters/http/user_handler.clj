(ns api.adapters.http.user-handler
  (:require [api.app.user-service :as user-service]
            [cheshire.core :as json]))

(defn build-response [ctx data]
  (.json ctx (json/generate-string data)))

(defn user [ctx]
  (let [name (.pathParam ctx "username")]
    (build-response ctx (user-service/get-user name))))

(defn users [ctx]
  (let [active (.queryParam ctx "active")]
    (build-response ctx (user-service/get-all-users (parse-boolean (or active "true"))))))
