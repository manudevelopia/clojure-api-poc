(ns api.adapters.http.user-handler
  (:require [api.adapters.http.common :as json]
            [api.app.user-service :as user-service]))

(defn user [ctx]
  (let [name (.pathParam ctx "username")]
    (json/build-response ctx (user-service/get-user name))))

(defn users [ctx]
  (let [active (.queryParam ctx "active")]
    (json/build-response ctx (user-service/get-all-users (parse-boolean (or active "true"))))))
