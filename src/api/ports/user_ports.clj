(ns api.ports.user-ports)

(defprotocol UserHandlerProtocol
  (all-users [this ctx])
  (user-by-name [this ctx]))

(defprotocol UserRepositoryProtocol
  (all [this active])
  (by-name [this username]))
