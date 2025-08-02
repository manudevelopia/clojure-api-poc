(ns api.app.building-service
  (:require [api.adapters.db.building-repository :as db]
            [api.ports.building-ports :as building-repo]
            [clojure.tools.logging :as log]))

(defn all []
  (log/info "Fetching all buildings")
  (building-repo/all (db/->BuildingRepository)))

(defn by-reference [reference]
  (log/info "Fetching building with reference" reference)
  (building-repo/by-reference (db/->BuildingRepository) reference))

