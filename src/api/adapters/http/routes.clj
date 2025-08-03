(ns api.adapters.http.routes
  (:require [api.adapters.http.building-handler :as building-handler]
            [api.adapters.http.product-handler :as product-handler]
            [api.adapters.http.user-handler :as user-handler]
            [api.ports.building-ports :as building-ports]
            [api.ports.product-ports :as product-ports]
            [api.ports.user-ports :as user-ports])
  (:import (io.javalin Javalin))
  (:gen-class))

(defn enableCors [ctx]
  (.header ctx "Access-Control-Allow-Origin" "*")
  (.header ctx "Access-Control-Allow-Methods" "GET, POST, PUT, DELETE, OPTIONS")
  (.header ctx "Access-Control-Allow-Headers" "Content-Type, Authorization")
  (.header ctx "Access-Control-Max-Age" "3600"))

(defn start-server []
  (doto (Javalin/create)
    (.before (fn [ctx] (enableCors ctx)))
    (.get "/hello" (fn [ctx] (.result ctx "Hello World!")))
    (.get "/users" (fn [ctx] (user-ports/all (user-handler/->UserHandler) ctx)))
    (.get "/users/{username}" (fn [ctx] (user-ports/by-name (user-handler/->UserHandler) ctx)))
    (.get "/products" (fn [ctx] (product-ports/all (product-handler/->ProductHandler) ctx)))
    (.get "/products/{sku}" (fn [ctx] (product-ports/by-sku (product-handler/->ProductHandler) ctx)))
    (.get "/buildings" (fn [ctx] (building-ports/all (building-handler/->BuildingHandler) ctx)))
    (.get "/buildings/{reference}" (fn [ctx] (building-ports/by-reference (building-handler/->BuildingHandler) ctx)))
    (.start 7000)))
