(ns api.ports.user-repository)

(defprotocol UserRepositoryProtocol
  (all [this active])
  (by-name [this username]))
