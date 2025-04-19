(ns api.app.user-service
  (:require [api.adapters.db.user-repository :as db]
            [api.ports.user-repository :as user-repo]
            [clojure.tools.logging :as log]))

(defn get-user [username]
  (log/info "Fetching user" username)
  (user-repo/get-user (db/new-user-repo "") username))

(defn get-all-users [active]
  (log/info "Fetching all users")
  (user-repo/get-all-users (db/new-user-repo) active))

