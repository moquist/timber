(ns timber.core
  (:require [net.cgrand.enlive-html :as html]))

(def bootstrap-css-selector [[:link (html/attr-has :id "bootstrap-css")]])
(def bootstrap-css-theme-selector [[:link (html/attr-has :id "bootstrap-theme-css")]])
(def bootstrap-js-selector [[:script (html/attr-has :href "bootstrap.js")]])

(def user-name-selector [[:span#username]])


