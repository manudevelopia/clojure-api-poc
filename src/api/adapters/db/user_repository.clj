(ns api.adapters.db.user-repository
  (:require [api.adapters.db.db :as db]
            [api.ports.user-ports :as repo]
            [clojure.tools.logging :as log]))

(defrecord UserRepository [] repo/UserProtocol
  (all [_ active]
    (log/info "Fetching all users")
    (db/execute! ["select id
                         ,username
                         ,email
                         ,is_active
                         ,created_at
                         ,updated_at
                from meeknu.users
                where is_active = ?"
                  active]))
  (by-name [_ name]
    (log/info "Fetching user" name)
    (db/execute-one! ["select id
                             ,username
                             ,email
                             ,is_active
                             ,created_at
                             ,updated_at
               from meeknu.users
               where username = ?"
                      name])))
