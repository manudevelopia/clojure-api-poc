(ns api.adapters.db.db
  (:require [api.env :as env]
            [next.jdbc :as jdbc]
            [next.jdbc.result-set :as rs]))

(def db-spec
  {:dbtype   "postgresql"
   :dbname   (env/get-env :DBNAME)
   :host     (env/get-env :HOST)
   :port     (env/get-env :PORT)
   :user     (env/get-env :USER)
   :password (env/get-env :PASSWORD)})

(def datasource (jdbc/get-datasource db-spec))

(def default-opts {:builder-fn rs/as-unqualified-kebab-maps})

(defn execute! [sql]
  (jdbc/execute! datasource sql default-opts))


