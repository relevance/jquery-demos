(ns jquery.labs.comments
  (:use [clojure.contrib def logging]
        compojure
        util.string-template)
  (:refer-clojure :exclude (get)))

(defvar
  comments
  (atom ())
  "List of comments")

(defn get [_]
  (render-template "comments" {:comments @comments}))

(defn post [request]
  (swap! comments conj (-> request :params :comment))
  (redirect-to "/labs/comments"))