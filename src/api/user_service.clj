(ns api.user-service
  (:require [api.db :as db]
            [clojure.tools.logging :as log]))

(defn get-user [username]
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

(defn get-all-users [active]
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

