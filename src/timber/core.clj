(ns timber.core
  (:require [net.cgrand.enlive-html :as html]
            [timber.selectors :as select]
            [timber.assets :as asset]))

(def helmsman-assets
  [^{:id :timber/assets}
   [:resources "/timber/public" {:root "/timber/public"}]])

(html/defsnippet main-menu
  "timber/templates/base.html"
  select/main-menu
  [menu-items]
  [:li] (html/clone-for [{:keys [menu-name menu-url]} menu-items]
                        [:li :a] (html/content menu-name)
                        [:li :a] (html/set-attr :href menu-url)))

(html/defsnippet user-menu
  "timber/templates/base.html"
  select/user-menu
  [menu-items]
  [:li] (html/clone-for [{:keys [menu-name menu-url]} menu-items]
                        [:li :a] (html/content menu-name)
                        [:li :a] (html/set-attr :href menu-url)))

(html/defsnippet extra-styles
  "timber/templates/tags/link.html"
  [:link]
  [stylesheet-uris]
  [:link] (html/clone-for [uri stylesheet-uris]
                          [:link] (html/set-attr :href uri)))

(html/defsnippet extra-scripts
  "timber/templates/tags/script.html"
  [:script]
  [script-uris]
  [:script] (html/clone-for [uri script-uris]
                            [:script] (html/set-attr :src uri)))

(html/deftemplate
  base-page
  "timber/templates/base.html"
  [{:keys [page-name brand asset-uri-path user-name main-menu
           user-menu page-content extra-styles extra-scripts
           ng-app] :as opts}]

  select/html            (html/set-attr :ng-app (or ng-app (str "")))
  select/head            (html/append extra-styles)
  select/body            (html/append extra-scripts)

  select/title           (html/content page-name)
  select/brand-title     (html/content (or brand page-name))
  select/link-asset      (asset/transform-link asset-uri-path)
  select/js-asset        (asset/transform-script-src asset-uri-path)
  select/main-menu       (html/content main-menu)
  select/user-menu       (html/content user-menu)
  select/user-name       (html/content user-name)
  select/content         (html/content page-content))
