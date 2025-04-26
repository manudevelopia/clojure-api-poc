(ns api.adapters.db.db
  (:require [api.env :as env]
            [next.jdbc :as jdbc]
            [next.jdbc.result-set :as rs]))

(def db-spec
  {:dbtype   "postgresql"
   :dbname   (env/env "DBNAME")
   :host     (env/env "HOST")
   :port     (env/env "PORT")
   :user     (env/env "USER")
   :password (env/env "PASSWORD")})

(def datasource (jdbc/get-datasource db-spec))

(def default-opts {:builder-fn rs/as-unqualified-kebab-maps})

(defn execute! [sql]
  (jdbc/execute! datasource sql default-opts))

(defn execute-one! [sql]
  (jdbc/execute-one! datasource sql default-opts))

