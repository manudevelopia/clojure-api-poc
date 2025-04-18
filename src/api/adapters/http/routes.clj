(ns api.adapters.http.routes
  (:require [api.adapters.http.user-handler :as user-handler])
  (:import (io.javalin Javalin))
  (:gen-class))

(defn start-server []
  (doto (Javalin/create)
    (.get "/hello" (fn [ctx] (.result ctx "Hello World!")))
    (.get "/users/{username}" user-handler/user)
    (.get "/users" user-handler/users)
    (.start 7000)))
