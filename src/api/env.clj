(ns api.env
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn env
  [k & [default]]
  (or (System/getenv k) default))

(defonce ^:private parsed-env (atom nil))

(defn- parse-line [line]
  (let [[key value] (string/split line #"=" 2)]
    [(keyword key) value]))

(defn- load-env-map [filename]
  (->> (slurp (io/file filename))
       string/split-lines
       (remove #(or (string/blank? %) (string/starts-with? % "#")))
       (map parse-line)
       (into {})))

(defn get-env [key]
  (when (nil? @parsed-env)
    (reset! parsed-env (load-env-map ".env")))
  (get @parsed-env key))
