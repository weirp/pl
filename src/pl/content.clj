(ns pl.content
  (:require [hiccup.core :refer [html h]]
            [hiccup.page :refer [html5]]
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
      [:li (link-to ( url "/tl") "Timeline")]
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

(defn trax-page [trax]
  (html5 {:lang :en}
         [:head
          [:title "Listronica"]
          [:meta {:name :viewport
                  :content "width=device-width, initial-scale=1.0"}]
          [:link {:href "/bootstrap/css/bootstrap.min.css"
                  :rel :stylesheet}]
          [:link {:href "/vis/css/vis.min.css"
                  :rel :stylesheet}]]
         [:body
          [:div.container]
          [:h1 "My Items"]
          [:div.row
           (if (seq trax)
             [:table.table.table-striped
              [:thead
               [:tr
                [:th "contract id"]
                [:th "Description"]
                ]]
              [:tbody
               (for [i trax]
                 [:tr
                  [:td (h (:contract_id i))]
                  [:td (h (:description i))]

                  ])]]
             [:div.col-sm-offset-1 "There are no trax."])]
          [:div.col-sm-6
           [:h2 "Create a new item"]
           [:br]]

          [:div.row]

          [:div#timeline.timeline]

          [:script {:src "http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"}]
          [:script {:src "/bootstrap/js/bootstrap.min.js"}]
          [:script {:src "/js/main.js"}]
          [:script {:src "/build_timeline.js"}]]
         ))
