(ns pl.content
  (:require [hiccup.core :refer [html]]
            [hiccup.page]
            [hiccup.element :refer [link-to]]
            [hiccup.util :refer [url]]))

(defn home []

  (html

   [:head
    [:title "Home Page"]

    [:body
     [:ul
      ;;[:li (link-to (url "/contracts") "Contracts")]
      [:li (link-to (url "/cdmsContracts") "CDMS Contracts")]
      [:li (link-to (url "/cdmsChildMap") "CDMS Child Map")]
      [:li (link-to (url "/cdmsSupplierMap") "CDMS Supplier Map")]
      [:li (link-to (url "/cdmsContractNumberMap") "CDMS Contract number Map")]
      [:li (link-to (url "/tendersContracts") "Tenders Contracts")]
      ]]]))

(defn display-contracts [c]
  (html
   [:head
    [:title "Contracts"]

    [:body
     [:h1 "Contracts"]
     [:div
      [:ul
       (map (fn [x] [:li (:name x)]) c)]]]]))

(defn display-cdms-contracts [c]
  (html
   [:head
    [:title "Cdms Contracts"]

    [:body
     [:h1 "Cdms Contracts"]
     [:div
      [:ul
       (map (fn [x] [:li (str "contractid=" (:contractid x) " parent=" (:parentcontractid x)
                              "    " (:contract x) )]) c)]]]]))

(defn display-tenders-contracts [c]
  (html
   [:head
    [:title "Tenders Contracts"]

    [:body
     [:h1 "Tenders Contracts"]
     [:div
      [:ul
       (map (fn [x] [:li (str (:contract_id x) "  " (:code x) "<br> " x)]) (vals c))]]]]))

(defn display-cdms-child-map [c]
  (html
   [:head
    [:title "Cdms Contracts Child Map"]

    [:body
     [:h1 "Cdms Contracts Child Map"]
     [:div
      [:ul
       (map (fn [x] [:li x]) c)]]]]))

(defn display-cdms-supplier-map [c]
  (html
   [:head
    [:title "Cdms Contracts Supplier Map"]

    [:body
     [:h1 "Cdms Contracts Supplier Map"]
     [:div
      [:ul
       (map (fn [x] [:li x]) c)]]]]))

(defn display-cdms-contract-number-map [c]
  (html
   [:head
    [:title "Cdms Contracts Number Map"]

    [:body
     [:h1 "Cdms Contracts Number Map"]
     [:div
      [:ul
       (map (fn [x] [:li x]) c)]]]]))
