(ns pl.handler
  (:require cljsjs.vis))

(defonce appstate (atom {}))

(def data [
           {:id 11
            :start (js/Date. 2016 7 15)
            :end (js/Date. 2016 8 14)
            :group "c1"
            :style "background-color: red"
            :content "Init Trajectory A"}
           {:id 12
            :start (js/Date. 2016 8 15)
            :end (js/Date. 2016 9 14)
            :group "c1"
            :style "background-color: yellow"
            :content "OPt 1 Trajectory A"}
           {:id 13
            :start (js/Date. 2016 9 15)
            :end (js/Date. 2016 10 14)
            :group "c1"
            :style "background-color: green"
            :content "opt 2"}


           {:id 21
            :start (js/Date. 2016 9 22)
            :end (js/Date. 2017 9 21)
            :group "c2"
            :style "background-color: red"
            :content "Trajectory B init"}
           {:id 22
            :start (js/Date. 2017 9 22)
            :end (js/Date. 2018 9 21)
            :group "c2"
            :style "background-color: blue"
            :content "Trajectory B opt 1"}
           {:id 23
            :start (js/Date. 2018 9 22)
            :end (js/Date. 2019 3 22)
            :group "c2"
            :style "background-color: yellow"
            :content "Trajectory B/2"}
           {:id 24
            :start (js/Date. 2016 12 23)
            :group "c2"
            :type "point"
            :content "Business Plan"}
           {:id 25
            :start (js/Date. 2017 7 3)
            :group "c2"
            :type "point"
            :content "Thing started"}
           {:id 26
            :start (js/Date. 2017 8 13)
            :group "c2"
            :type "point"
            :content "Other thing started"}

           {:id 3 :start (js/Date. 2016 8 7)
            :end (js/Date. 2017 9 18)
            :group "c3"
            :style "background-color: blue"
            :content "Trajectory C"}

           {:id 41
            :start (js/Date. 2016 9 22)
            :end (js/Date. 2017 9 21)
            :group "c4"
            :style "background-color: red"
            :content "Trajectory B init"}
           {:id 42
            :start (js/Date. 2017 9 22)
            :end (js/Date. 2018 9 21)
            :group "c4"
            :style "background-color: blue"
            :content "Trajectory B opt 1"}
           {:id 43
            :start (js/Date. 2018 9 22)
            :end (js/Date. 2019 3 22)
            :group "c4"
            :style "background-color: yellow"
            :content "Trajectory B/2"}

           {:id 51
            :start (js/Date. 2016 9 22)
            :end (js/Date. 2017 9 21)
            :group "c5"
            :style "background-color: red"
            :content "Trajectory B init"}
           {:id 52
            :start (js/Date. 2017 9 22)
            :end (js/Date. 2018 9 21)
            :group "c5"
            :style "background-color: blue"
            :content "Trajectory B opt 1"}
           {:id 53
            :start (js/Date. 2018 9 22)
            :end (js/Date. 2019 3 22)
            :group "c5"
            :style "background-color: yellow"
            :content "Trajectory B/2"}


           ])

(defn build-timeline []
  (let [items (js/vis.DataSet. (clj->js  data))
        options (clj->js {
                          :type "range"
                          :timeAxis {:scale "day"}
                          :editable true
                          :stack true
                          :configure true
                          :margin {:item {:horizontal 0}}
                          :multiselect true
                          })
        groups (clj->js [
                         {:id "c1" :content "c1"}
                         {:id "c2" :content "c2"}
                         {:id "c3" :content "c3"}
                         {:id "c4" :content "c4"}
                         {:id "c5" :content "c5"}
                         ])
        container (. js/document (getElementById "timeline"))]
    (js/vis.Timeline. container items groups options) ) )
