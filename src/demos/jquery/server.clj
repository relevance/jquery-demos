(use 'compojure
     'demos.jquery.main)

(run-server {:port 8080} "/*" (servlet demo-server))