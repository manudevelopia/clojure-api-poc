(ns api.ports.user-ports)

(defprotocol UserProtocol
  (all [this arg0])
  (by-name [this arg0]))
