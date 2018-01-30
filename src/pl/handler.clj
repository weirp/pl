(ns pl.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]

            [hiccup.core]
            [hiccup.page :only (html5 include-css include-js)]

            [pl.data :as d]
            [pl.content :as c]

;;            [ring.adapter.jetty :as jetty]
;;            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.cljsjs :refer [wrap-cljsjs]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.resource :refer [wrap-resource]]

            ))

;;(:require
 ;;[ring.adapter.jetty :as jetty]
          ;;[ring.middleware.reload :refer [wrap-reload]]
          ;;[compojure.core :refer [defroutes ANY GET POST PUT DELETE]]
          ;;[compojure.route :refer [not-found]]
          ;;[ring.handler.dump :refer [handle-dump]]
          ;;[ring.middleware.params :refer [wrap-params]]
          ;;[ring.middleware.resource :refer [wrap-resource]]
          ;;[ring.middleware.file-info :refer [wrap-file-info]]
;;[ring.middleware.cljsjs :refer [wrap-cljsjs]])


(defroutes app-routes
  (GET "/" [] (c/home))
  (GET "/contracts" [] (c/display-contracts (d/load-contracts)))
  (GET "/cdmsContracts" [] (c/display-cdms-contracts (d/loadCdmsContracts)))
  (GET "/tendersContracts" [] (c/display-tenders-contracts (d/loadTendersContracts)))

  (GET "/cdmsChildMap" [] (c/display-cdms-child-map (d/buildCdmsParentChildMap (d/loadCdmsContracts))))
  (GET "/cdmsSupplierMap" [] (c/display-cdms-supplier-map (d/buildCdmsParentSupplierMap (d/loadCdmsContracts))))
  (GET "/cdmsContractNumberMap" [] (c/display-cdms-contract-number-map (d/buildCdmsParentContractNumberMap (d/loadCdmsContracts))))
  (GET "/tl" [] (c/trax-page (d/traxData)))
  (route/not-found "Not Found"))

(defn wrap-server [hdlr]
  (fn [req]
    (assoc-in (hdlr req) [:headers "Server"] "Hal 9000")))

(def app
  (wrap-cljsjs
   (wrap-server
    (wrap-resource
     (wrap-params
      (wrap-defaults
       app-routes site-defaults))
     "static"))))

(defn -dev-main [port]
  ;;(jetty/run-jetty (wrap-reload #'app) {:port (Integer. port)})
  )
