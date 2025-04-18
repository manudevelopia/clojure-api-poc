(ns api.ports.user-repository
  (:require [api.adapters.db.user-repository :as repository])
  )

(defn get-user [username]
  (repository/get-user username))

(defn get-all-users [active]
  (repository/get-all-users active))

