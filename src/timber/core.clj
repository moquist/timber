(ns timber.core
  (:require [net.cgrand.enlive-html :as html]))

(def title-selector [[:title]])

(def link-asset-selector [[:link (html/attr? :asset)]])
(def js-asset-selector [[:script (html/attr? :asset)]])

(def main-menu-selector [[:ul#main-menu]])
(def side-menu-selector [[:ul#side-menu]])

(def link-template-selector [[:link (html/attr? :template)]])
(def script-template-selector [[:script (html/attr? :template)]])

(def content-selector [[:div#content]])

(defn default-transformations
  [request]
  {content-selector [(html/content "foo")]})

(defn template
  [request selector-map]
  (let [merged-map (merge-with #(conj %1 %2) (default-transformations request) selector-map)
        ;;;transform-map (into {} (map #([(first %1) (apply html/do-> (second %1))]) merged-map))
        get-selector (partial get merged-map)
        ]
    (prn merged-map)
    (html/template "timber/templates/base.html"
                   [get-selector]
                   title-selector (get-selector title-selector)
                   link-asset-selector (get-selector link-asset-selector)
                   js-asset-selector (get-selector js-asset-selector)
                   main-menu-selector (get-selector main-menu-selector)
                   side-menu-selector (get-selector side-menu-selector)
                   link-template-selector (get-selector link-template-selector)
                   script-template-selector (get-selector script-template-selector)
                   content-selector (get-selector content-selector))))

