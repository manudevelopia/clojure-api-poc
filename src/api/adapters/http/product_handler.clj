(ns api.adapters.http.product-handler
  (:require [api.adapters.http.common :as json]
            [api.app.product-service :as product-service]
            [api.ports.product-ports :as product-ports]))

(defrecord ProductHandler [] product-ports/ProductHandlerProtocol
  (all-products [_ ctx]
    (json/build-response ctx (product-service/all)))

  (product-by-sku [_ ctx]
    (let [sku (.pathParam ctx "sku")]
      (json/build-response ctx (product-service/by-sku sku)))))
