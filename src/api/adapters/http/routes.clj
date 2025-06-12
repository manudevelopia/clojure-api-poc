(ns api.adapters.http.routes
  (:require [api.adapters.http.product-handler :refer [->ProductHandler]]
            [api.adapters.http.user-handler :refer [->UserHandler]]
            [api.ports.product-ports :as product]
            [api.ports.user-ports :as user])
  (:import (io.javalin Javalin))
  (:gen-class))

(defn start-server []
  (doto (Javalin/create)
    (.get "/hello" (fn [ctx] (.result ctx "Hello World!")))
    (.get "/users" (fn [ctx] (user/all (->UserHandler) ctx)))
    (.get "/users/{username}" (fn [ctx] (user/by-name (->UserHandler) ctx)))
    (.get "/products" (fn [ctx] (product/all (->ProductHandler) ctx)))
    (.get "/products/{sku}" (fn [ctx] (product/by-sku (->ProductHandler) ctx)))
    (.start 7000)))
