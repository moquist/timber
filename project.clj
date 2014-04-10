(defproject vlacs/timber "0.1.0-SNAPSHOT"
  :description "UI Library for VLACS applications"
  :url "http://vlacs.org"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [enlive "1.1.5"]]

  :pedantic? :warn

  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]]
                   :source-paths ["dev"]}})
