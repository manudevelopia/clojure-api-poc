(ns api.ports.building-ports)

(defprotocol BuildingProtocol
  (all [this] [this arg0])
  (by-reference [this arg0]))
