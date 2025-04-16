(ns api.db
  (:require [next.jdbc :as jdbc]
            [next.jdbc.result-set :as rs]))

(def db-spec
  {:dbtype   "postgresql"
   :dbname   "koyebdb"
   :host     "ep-patient-term-a23fmx3b.eu-central-1.pg.koyeb.app"
   :port     5432
   :user     "admin"
   :password "UZcg2mPYnky0"})

(def datasource (jdbc/get-datasource db-spec))

(def default-opts {:builder-fn rs/as-unqualified-kebab-maps})

(defn execute! [sql]
  (jdbc/execute! datasource sql default-opts))


