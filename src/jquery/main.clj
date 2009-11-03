(ns jquery.main
  (:use compojure
        util.string-template
        [clojure.contrib java-utils str-utils]
        clojure.contrib.logging
        clojure.contrib.json.write)
  (:require [jquery.labs.comments :as comments]
            [jquery.labs.invite :as invite]))

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

(defn demos []
  (->> (files "templates/demos")
       (filter #(re-find #".st$" %))
       (map #(re-sub #"\.st" "" %))))

(defn labs []
  ["invite", "comments"])

(defn demo [demo]
  (when (-> (str "templates/demos/" demo ".st") as-file .exists)
    (render-template "layouts/main" {:content (str "demos/" demo)})))

(defn links [group names]
  (map (fn [n]
         {:link (str "/" group "/" n)
          :name n})
       names))

(defn index [params]
  (render-template "index" {:params (json-str params)
                            :demos (links "demos" (demos))
                            :labs (links "labs" (labs))
                            :solutions (links "solutions" (labs))}))

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
  (GET "/solutions/comments"
       (comments/get request))
  (POST "/labs/comments"
        (comments/post request))
  (POST "/solutions/comments"
        (comments/post request))
  (GET "/labs/invite*"
       (invite/get request))
  (POST "/labs/invite"
        (invite/post request))
  (GET "/square"
      (let [i (Integer/parseInt (params :x))]
        (str (* i i))))        
  (GET "/solutions/invite*"
       (invite/get request))
  (POST "/solutions/invite"
        (invite/post request))
  
  (GET "/demos/*"
       (or (demo (params :*))
           :next))
  (ANY "*" (page-not-found))
)