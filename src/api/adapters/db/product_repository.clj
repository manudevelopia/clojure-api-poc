(ns api.adapters.db.product-repository
  (:require [api.adapters.db.db :as db]
            [api.ports.product-repository :as repo]
            [clojure.tools.logging :as log]))

(defrecord ProductRepository []
  repo/ProductRepositoryProtocol
  (all [_]
    (log/info "Fetching all products")
    (db/execute! ["select p_name name
                         ,p_description description
                         ,p_sku sku
                   from shop.products"]))
  (by-sku [_ sku]
    (log/info "Fetching product with sku" sku)
    (db/execute-one! ["select p_name name
                             ,p_description description
                             ,p_sku sku
                       from shop.products
                       where p_sku = ?" sku])))

(defn product-repository []
  (->ProductRepository))
