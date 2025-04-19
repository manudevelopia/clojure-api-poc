(ns api.ports.user-repository)

(defprotocol UserRepositoryProtocol
  (get-user [this username])
  (get-all-users [this active]))
