(ns api.adapters.db.user-repository
  (:require [api.adapters.db.db :as db]
            [api.ports.user-repository :as repo]
            [clojure.tools.logging :as log]))

(defrecord UserRepository []
  repo/UserRepositoryProtocol
  (get-user [_ username]
    (log/info "Fetching user" username)
    (db/execute! ["select id
                     ,username
                     ,email
                     ,is_active
                     ,created_at
                     ,updated_at
               from meeknu.users
               where username = ?"
                  username]))
  (get-all-users [_ active]
    (log/info "Fetching all users")
    (db/execute! ["select id
                      ,username
                      ,email
                      ,is_active
                      ,created_at
                      ,updated_at
                from meeknu.users
                where is_active = ?"
                  active])))

(defn user-repository []
  (->UserRepository))
