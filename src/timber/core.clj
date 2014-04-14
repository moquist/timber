(ns timber.core
  (:require [clojure.pprint :refer [pprint]]
            [net.cgrand.enlive-html :as html]))

(def title-selector [:title])

(def link-asset-selector [:link (html/attr? :asset)])
(def js-asset-selector [:script (html/attr? :asset)])

(def main-menu-selector [:ul#main-menu])
(def side-menu-selector [:ul#side-menu])

(def link-template-selector [:link (html/attr? :template)])
(def script-template-selector [:script (html/attr? :template)])

(def content-selector [:div#content])

(defn default-transformations
  [request]
  {title-selector (html/content "Default Title")
   content-selector (html/content "This is the content area.")})

(defn template
  [request selector-map]
  (let [merged-map (merge (default-transformations request) selector-map)
        get-transform (partial get merged-map)]
    (html/template "timber/templates/base.html"
                   [get-transforms]
                   title-selector (get-transform title-selector)
                   link-asset-selector (get-transform link-asset-selector)
                   js-asset-selector (get-transform js-asset-selector)
                   main-menu-selector (get-transform main-menu-selector)
                   side-menu-selector (get-transform side-menu-selector)
                   link-template-selector (get-transform link-template-selector)
                   script-template-selector (get-transform script-template-selector)
                   content-selector (get-transform content-selector))))
