(ns jquery.labs.invite
  (:use [clojure.contrib def logging]
        compojure
        util.string-template)
  (:refer-clojure :exclude (get)))

(defn get [request]
  (render-template
   "layouts/main"
   {:content (-> request :uri (.substring 1))}))

(defn post [request]
  (Thread/sleep 1000)                ; delay so we can see Ajax better
  (redirect-to (str (request :uri) "-thanks")))