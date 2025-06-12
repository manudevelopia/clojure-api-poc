(ns api.application.product-service
  (:require [api.adapters.db.product-repository :refer [->ProductRepository]]
            [api.ports.product-ports :as product-repo]
            [clojure.tools.logging :as log]))

(defn all []
  (log/info "Fetching all products")
  (product-repo/all (->ProductRepository)))

(defn by-sku [sku]
  (log/info "Fetching product with sku" sku)
  (product-repo/by-sku (->ProductRepository) sku))
