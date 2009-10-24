(ns jquery.main
  (:use compojure
        util.string-template
        [clojure.contrib java-utils str-utils]
        clojure.contrib.logging
        clojure.contrib.json.write)
  (:require [jquery.labs.comments :as comments]))

(defn log-request [request]
  (log :info (str
              (-> (:request-method request) name .toUpperCase) " "
              (:uri request)
              "\n\tParameters "
              (:params request)
              "\n\tPartial Headers "
              (-> request :headers (dissoc "cookie"))
              "\n\tSession "
              (:session request))))

(defn files [dir]
  (map #(.getName %) (-> dir as-file file-seq)))

(defn demo-templates []
  (->> (files "templates/demos")
       (filter #(re-find #".st$" %))
       (map #(re-sub #"\.st" "" %))))

(defn demo [demo]
  (when (-> (str "templates/demos/" demo ".st") as-file .exists)
    (render-template "demo-layout" {:demo (str "demos/" demo)})))

(defn index [params]
  (render-template "index" {:params (json-str params)
                            :demos (map
                                    (fn [t]
                                      {:link (str "/demos/" t), :name t})
                                    (demo-templates))}))

(defroutes server
  (GET "/"
       (index params))
  (GET "/*"
       (or (serve-file (params :*))
           :next))
  (ANY "/*"
       (log-request request)
       :next)
  (GET "/labs/comments"
       (comments/get request))
  (POST "/labs/comments"
       (comments/post request))
  (GET "/demos/*"
       (or (demo (params :*))
           :next))
  (ANY "*" (page-not-found))
)