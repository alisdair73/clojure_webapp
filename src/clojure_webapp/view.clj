(ns clojure_webapp.view
	  (:use hiccup.core)
    (:use hiccup.page)
    (:use hiccup.form)
	  (:use [clojure_webapp.database :as database]))

(defn write-persons[persons]
  (map (fn [person] [:tr [:td (person :firstname)]
                         [:td (person :lastname)]
                         [:td (person :id)]]) persons))

(defn render-main-page[]
  (html5
    [:head
      [:title "Netweaver Cloud - Persistence Example - Clojure Implementation"]]
    [:body
      [:table {:border 1} [:tr [:th {:colspan 3} "Entries in the Database"]] (write-persons (database/get-all-persons))]
      (form-to [:post "/clojure_webapp-1.0.0-SNAPSHOT-standalone"]
        "First name:" (text-field :firstname)
        " Last name:" (text-field :lastname)
        " Id:" (text-field :id)
        (submit-button "Add Person"))]))