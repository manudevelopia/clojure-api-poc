(ns api.adapters.http.common
  (:require [cheshire.core :as json]))

(defn build-response [ctx data]
  (.json ctx (json/generate-string data)))