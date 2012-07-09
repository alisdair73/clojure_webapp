(ns clojure_webapp.database
	(:use [clojure.java.jdbc :as sql]))

(def db {:name "java:comp/env/jdbc/DefaultDB"})

(defn create-person-table[]
  (sql/with-connection db
    (sql/create-table :person [:id :int "PRIMARY KEY"]
	                            [:firstname "varchar(20)"]
	                            [:lastname "varchar(20)"])))

(defn get-all-persons[] 
  (sql/with-connection db
  	(sql/with-query-results results
  		["SELECT * FROM person"] (into [] results))))

(defn add-person-to-table[person]
  (sql/with-connection db (sql/insert-record :person person)))

(defn table-exists?[]
  (let [metadata (sql/with-connection db 
                    (into [] 
                      (sql/resultset-seq (-> (sql/connection)
                                             (.getMetaData)
                                             (.getTables nil nil "PERSON" (into-array ["TABLE"]))))))]
  (not= [] metadata)))

(defn check-table-exists[] 
  (if (not (table-exists?))
      (create-person-table)))





