(ns api.adapters.db.user-repository
  (:require [api.adapters.db.db :as db]
            [api.ports.user-repository :as repo]))

;(defrecord PgUserRepo [ds]
;  repo/UserRepository
;  (defn get-user [_ username]
;    (log/info "Fetching user" username)
;    (db/execute! ["select id
;                       ,username
;                       ,email
;                       ,is_active
;                       ,created_at
;                       ,updated_at
;                 from meeknu.users
;                 where username = ?"
;                  username]))
;
;  (defn get-all-users [_ active]
;    (log/info "Fetching all users")
;    (db/execute! ["select id
;                       ,username
;                       ,email
;                       ,is_active
;                       ,created_at
;                       ,updated_at
;                 from meeknu.users
;                 where is_active = ?"
;                  active])))

(defrecord PgUserRepo [ds]
  repo/UserRepository
  (get-user [_ username]
    (db/execute! ["select id
                     ,username
                     ,email
                     ,is_active
                     ,created_at
                     ,updated_at
               from meeknu.users
               where username = ?"
                  username]))
  (get-all-users [_ user]
    (db/execute! ["INSERT INTO users (name, email) VALUES (?, ?)"
                  (:name user) (:email user)])))

(defn new-user-repo [ds]
  (->PgUserRepo ds))


;(defn get-user [username]
;  (log/info "Fetching user" username)
;  (db/execute! ["select id
;                       ,username
;                       ,email
;                       ,is_active
;                       ,created_at
;                       ,updated_at
;                 from meeknu.users
;                 where username = ?"
;                username]))
;
;(defn get-all-users [active]
;  (log/info "Fetching all users")
;  (db/execute! ["select id
;                       ,username
;                       ,email
;                       ,is_active
;                       ,created_at
;                       ,updated_at
;                 from meeknu.users
;                 where is_active = ?"
;                active]))
