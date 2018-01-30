# pl

Just merging some facets of various projects for demonstration and discussion.

Including some visualisation stuff (timeline). along with thew data migration stuff.

figwheel isn't going 100% as initially built a compojure/ring project.
Added the timeline code -- cljs ...

To fire it up,
* lein cljsbuild once
  to build the clojurescript
* lein ring server-headless


### Old
(use 'figwheel-sidecar.repl-api)
(start-figwheel!)

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2018 FIXME
