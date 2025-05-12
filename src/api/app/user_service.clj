(ns api.app.user-service
  (:require [api.adapters.db.user-repository :as db]
            [api.ports.user-repository :as user-repo]
            [clojure.tools.logging :as log]))

(defn get-user [name]
  (log/info "Fetching user" name)
  (user-repo/by-name (db/->UserRepository) name))

(defn get-all-users [active]
  (log/info "Fetching all users")
  (user-repo/all (db/->UserRepository) active))
