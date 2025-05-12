(ns api.env)

(defn get-value [k]
  (System/getenv k))
