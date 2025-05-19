(ns api.adapters.http.user-handler
  (:require [api.adapters.http.common :as json]
            [api.app.user-service :as user-service]
            [api.ports.user-ports :as user-handler]))

(defrecord UserHandler [] user-handler/UserProtocol
  (all [_ ctx]
    (let [active (.queryParam ctx "active")]
      (json/build-response ctx (user-service/get-all-users (parse-boolean (or active "true"))))))

  (by-name [_ ctx]
    (let [name (.pathParam ctx "username")]
      (json/build-response ctx (user-service/get-user name)))))
