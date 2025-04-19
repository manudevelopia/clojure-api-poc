(ns api.ports.user-repository)

(defprotocol UserRepository
  (get-user [this username])
  (get-all-users [this active]))
