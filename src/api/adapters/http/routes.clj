(ns api.adapters.http.routes
  (:require [api.adapters.http.product-handler :as product-handler]
            [api.adapters.http.user-handler :as user-handler]
            [api.ports.product-ports :as product-ports]
            [api.ports.user-ports :as user-ports])
  (:import (io.javalin Javalin))
  (:gen-class))

(defn start-server []
  (doto (Javalin/create)
    (.get "/hello" (fn [ctx] (.result ctx "Hello World!")))
    (.get "/users" (fn [ctx] (user-ports/all-users (user-handler/->UserHandler) ctx)))
    (.get "/users/{username}" (fn [ctx] (user-ports/user-by-name (user-handler/->UserHandler) ctx)))
    (.get "/products" (fn [ctx] (product-ports/all-products (product-handler/->ProductHandler) ctx)))
    (.get "/products/{sku}" (fn [ctx] (product-ports/product-by-sku (product-handler/->ProductHandler) ctx)))
    (.start 7000)))
