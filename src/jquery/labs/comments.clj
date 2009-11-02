(ns jquery.labs.comments
  (:use [clojure.contrib def logging]
        compojure
        util.string-template)
  (:refer-clojure :exclude (get)))

(defvar
  comments
  (atom ())
  "List of comments")

(defn ajax? [request]
  (= (-> request :headers (clojure.core/get "x-requested-with")) "XMLHttpRequest"))

(defn get [request]
  (render-template
   "layouts/main"
   {:content (-> request :uri (.substring 1))
    :comments @comments}))

(defn post [request]
  (Thread/sleep 1000) ; delay so we can see Ajax better
  (swap! comments conj (-> request :params :comment))
  (if (ajax? request)
    "comment posted"
    (redirect-to (-> request :uri))))