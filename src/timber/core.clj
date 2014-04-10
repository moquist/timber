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

