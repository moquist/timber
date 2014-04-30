(ns timber.selectors
  (:require [net.cgrand.enlive-html :as html]))

(def html [:html])
(def head [:head])
(def body [:body])

(def title [:title])

(def brand-title [:a#brand])

(def link-asset [[:link (html/attr? :asset)]])
(def js-asset [[:script (html/attr? :asset)]])

(def main-menu [:ul#main-menu-list])
(def user-menu [:ul#user-account-menu])
(def user-name [:a#user-menu-toggle])

(def link-template [[:link (html/attr? :template)]])
(def script-template [[:script (html/attr? :template)]])

(def content [:div#content])
