(ns api.adapters.db.building-repository
  (:require [api.adapters.db.db :as db]
            [api.ports.building-ports :as repo]
            [clojure.tools.logging :as log]))

(defrecord BuildingRepository [] repo/BuildingProtocol
  (all [_]
    (log/info "Fetching all buildings")
    (db/execute! ["select b_reference reference
                       ,b_title title
                       ,b_details details
                       ,b_price price
                 from idealista.buildings"]))
  (by-reference [_ reference]
    (log/info "Fetching building with reference" reference)
    (db/execute-one! ["select b_reference reference
                        ,b_title title
                        ,b_details details
                        ,b_price price
                  from idealista.buildings
                 WHERE b_reference = ?" (str "/inmueble/" reference "/")])))
