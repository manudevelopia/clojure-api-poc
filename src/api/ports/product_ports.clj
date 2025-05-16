(ns api.ports.product-ports)

(defprotocol ProductHandlerProtocol
  (all-products [this ctx])
  (product-by-sku [this ctx]))

(defprotocol ProductRepositoryProtocol
  (all [this])
  (by-sku [this sku]))
