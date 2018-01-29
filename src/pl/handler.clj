(ns pl.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]

            [hiccup.core]
            [hiccup.page :only (html5 include-css include-js)]

            [pl.data :as d]
            [pl.content :as c]))

(defroutes app-routes
  (GET "/" [] (c/home))
  (GET "/contracts" [] (c/display-contracts (d/load-contracts)))
  (GET "/cdmsContracts" [] (c/display-cdms-contracts (d/loadCdmsContracts)))
  (GET "/tendersContracts" [] (c/display-tenders-contracts (d/loadTendersContracts)))

  (GET "/cdmsChildMap" [] (c/display-cdms-child-map (d/buildCdmsParentChildMap (d/loadCdmsContracts))))
  (GET "/cdmsSupplierMap" [] (c/display-cdms-supplier-map (d/buildCdmsParentSupplierMap (d/loadCdmsContracts))))
  (GET "/cdmsContractNumberMap" [] (c/display-cdms-contract-number-map (d/buildCdmsParentContractNumberMap (d/loadCdmsContracts))))

  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
