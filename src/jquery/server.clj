(use 'compojure
     'jquery.main)

(run-server {:port 8080} "/*" (servlet server))