(ns api.ports.product-ports)

(defprotocol ProductProtocol
  (all [this] [this arg0])
  (by-sku [this arg0]))
