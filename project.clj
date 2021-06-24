(defproject friendwall "0.1.0-SNAPSHOT"
  :description "Demo App for a small social network"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  ; This dependencies came from https://clojars.org/
  :dependencies [[org.clojure/clojure "1.10.1"] ; default dependency
                 [ring "1.8.0"] ; to run a web service
                 [compojure "1.6.2"] ; define routes
                 [ring/ring-defaults "0.3.2"] ; Add a middleware in the web service 
                                              ; to handle sensible and secure configurations
                 [yogthos/config "1.1.7"] ; enables use of environment variables
                 [rum "0.12.6"] ; translate the clojure code to html
                 [com.github.seancorfield/next.jdbc "1.2.674"] ; A wrapper to acces databases
                 [org.postgresql/postgresql "42.2.11"]
                 [migratus "1.3.5"]] ; to work with migration
  :main ^:skip-aot friendwall.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
