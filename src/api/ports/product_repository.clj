(ns api.ports.product-repository)

(defprotocol ProductRepositoryProtocol
  (all [this])
  (by-sku [this sku]))
