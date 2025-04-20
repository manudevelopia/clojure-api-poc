(ns api.app.product-service
  (:require [api.adapters.db.product-repository :as db]
            [api.ports.product-repository :as product-repo]
            [clojure.tools.logging :as log]))

(defn all []
  (log/info "Fetching all products")
  (product-repo/all (db/product-repository)))

(defn by-sku [sku]
  (log/info "Fetching product with sku" sku)
  (product-repo/by-sku (db/product-repository) sku))
