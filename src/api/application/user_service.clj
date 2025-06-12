(ns api.application.user-service
  (:require [api.adapters.db.user-repository :refer [->UserRepository]]
            [api.ports.user-ports :as user-repo]
            [clojure.tools.logging :as log]))

(defn get-user [name]
  (log/info "Fetching user" name)
  (user-repo/by-name (->UserRepository) name))

(defn get-all-users [active]
  (log/info "Fetching all users")
  (user-repo/all (->UserRepository) active))
