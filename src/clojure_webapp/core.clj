(ns clojure_webapp.core
	(:use ring.util.response)
	(:use [clojure_webapp.view :as view])
	(:use [clojure_webapp.database :as database])
	(:use compojure.core)
	(:require [compojure.route :as route]
            [compojure.handler :as handler]))

(defn do-get[]
  (database/check-table-exists)
  (view/render-main-page))

(defn do-post[person]
  (database/add-person-to-table person)
  (view/render-main-page))

(defroutes build-route-map
  (GET "/" [] (do-get))
  (POST "/" {person :params} (do-post person))
  (route/not-found "Page not found"))

(def app-setup (handler/site build-route-map))


 