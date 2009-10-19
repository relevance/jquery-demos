(ns demos.jquery.main
  (:use compojure
        util.string-template
        [clojure.contrib java-utils str-utils]
        clojure.contrib.json.write))

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
(defroutes demo-server
  (GET "/"
       (index params))
  
  (GET "/*"
       (or (serve-file (params :*))
           :next))
  (GET "/demos/*"
       (or (demo (params :*))
           :next))
  (ANY "*" (page-not-found)))

