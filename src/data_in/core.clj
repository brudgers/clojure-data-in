(ns data-in.core
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))


(defn- get-data
  [data-file f]
  (with-open [rdr (clojure.java.io/reader data-file)]
        (doall (map f (line-seq rdr)))))


(defn- f
  [line]
  (vec (map (fn [x] (edn/read-string x)) 
            (clojure.string/split line #" "))))

(defn data-in
  [filename]
  (vec (get-data filename f)))



