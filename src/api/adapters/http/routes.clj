(ns api.adapters.http.routes
  (:require [api.adapters.http.product-handler :as product-handler]
            [api.adapters.http.user-handler :as user-handler])
  (:import (io.javalin Javalin))
  (:gen-class))

(defn start-server []
  (doto (Javalin/create)
    (.get "/hello" (fn [ctx] (.result ctx "Hello World!")))
    (.get "/users/{username}" user-handler/by-name)
    (.get "/users" user-handler/all)
    (.get "/products" product-handler/all)
    (.get "/products/{sku}" product-handler/by-sku)
    (.start 7000)))
