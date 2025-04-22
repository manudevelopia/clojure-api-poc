(ns api.adapters.http.product-handler
  (:require [api.adapters.http.common :as json]
            [api.app.product-service :as product-service]))

(defn all [ctx]
  (json/build-response ctx (product-service/all)))

(defn by-sku [ctx]
  (let [sku (.pathParam ctx "sku")]
    (json/build-response ctx (product-service/by-sku sku))))