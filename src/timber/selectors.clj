(ns timber.selectors
  (:require [net.cgrand.enlive-html :as html]))

(def html [:html])
(def head [:head])
(def body [:body])

(def title [:title])

(def brand-title [:a#brand])

(def link-asset [:head [:link (html/attr? :asset)]])
(def link-template [:head [:link (html/attr? :template)]])
(def js-asset [:head [:script (html/attr? :asset)]])
(def script-template [[:script (html/attr? :template)]])

(def main-menu [:ul#main-menu-list])
(def user-menu [:ul#user-account-menu])
(def user-name [:a#user-menu-toggle])

(def content [:div#content])

(defn first-of-type
  "Searches the template for the first type of specified element"
  [type template]
  (html/select
    (html/html-resource (str "timber/templates/" template))
    [[type (html/nth-of-type 1)]]))
