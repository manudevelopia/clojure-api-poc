(ns build
  (:require [clojure.java.shell :as shell]
            [clojure.tools.build.api :as b]))

(def lib 'api/app)
(def version "0.0.1")
(def main 'api.core)

(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file (format "target/%s-%s-standalone.jar" (name lib) version))

(defn clean [_]
      (b/delete {:path "target"}))

(defn uber [_]
      (clean nil)
      (b/copy-dir {:src-dirs ["src"] :target-dir class-dir})
      (b/compile-clj {:basis     basis
                      :src-dirs  ["src"]
                      :class-dir class-dir})
      (b/uber {:class-dir class-dir
               :uber-file jar-file
               :basis     basis
               :main      main
               :manifest  {"Main-Class" "api.core"}})
      (println "Built" jar-file))

(defn docker [_]
      (println "Building Docker image " (name lib))
      (uber nil)
      (let [{:keys [exit out err]}
            (shell/sh "docker" "build" "-t" (name lib) "." "-f" "docker/Dockerfile")]
           (println "Docker build output:" out)
           (when (not= exit 0)
                 (throw (ex-info "Docker build failed" {:error err})))))
