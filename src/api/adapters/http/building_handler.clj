(ns api.adapters.http.building-handler
  (:require [api.adapters.http.common :as json]
            [api.app.building-service :as building-service]
            [api.ports.building-ports :as building-ports]))

(defrecord BuildingHandler [] building-ports/BuildingProtocol
  (all [_ ctx]
    (json/build-response ctx (building-service/all)))

  (by-reference [_ ctx]
    (let [reference (.pathParam ctx "reference")]
      (json/build-response ctx (building-service/by-reference reference)))))