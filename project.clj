(defproject pl "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [hiccup "1.0.5"]
                 [cljsjs/react-dom-server "15.4.2-2"]

                 ;;[ring "1.6.3"]
                 [ring-cljsjs "0.1.0"]
                 [cljsjs/vis "4.20.1-0"]
                 [org.clojure/clojurescript "1.9.946"]
                 ]

  ;;:main pl.handler
  :plugins [[lein-ring "0.9.7"]
            [lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.14"]
            ]

  :source-paths ["src"]

  :ring {:handler pl.handler/app}

  :clean-targets ^{:protect false} [:target-path "out"]

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src"]
                        :figwheel true
                        :compiler {:main pl.handler
                                   :output-to "resources/static/js/main.js"
                                   :output-dir "resources/static/js/out"
                                   :asset-path "js/out"
                                   }}]}
  :profiles
  {:dev
   {
    ;;:main pl.handler/-dev-main
    :dependencies [[javax.servlet/servlet-api "2.5"]
                   [ring/ring-mock "0.3.0"]
                   [com.cemerick/piggieback "0.2.2"]
                   [org.clojure/tools.nrepl "0.2.10"]
                   [figwheel-sidecar "0.5.13"]
                   ]
    :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}})
