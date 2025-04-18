(ns api.core
  (:require [api.adapters.http.routes :as router])
  (:gen-class))

(defn -main []
  (router/start-server))
