(ns util.string-template
  (:use clojure.walk [clojure.contrib java-utils logging pprint])
  (:import [org.antlr.stringtemplate StringTemplateGroup StringTemplateErrorListener]))

(defn load-template-group [path]
  (doto (org.antlr.stringtemplate.StringTemplateGroup. path)
    (.setErrorListener
     (proxy [StringTemplateErrorListener] []
       (error [s t] (throw t))
       (warning [s] (log :warning (str "StringTemplate warning " s)))))))

(defn template-group []
  (load-template-group "templates"))

(defn populate-template [template-path attributes]
  (log :info (str "Rendering template " template-path))
  (let [template (.getInstanceOf (template-group) template-path)]
    (doseq [[k v] (stringify-keys attributes)]
      (.setAttribute template (as-str k) v))
    template))
  
(defn render-template [template-path attributes]
  (str (populate-template template-path attributes)))