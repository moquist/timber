(ns timber.core
  (:require [net.cgrand.enlive-html :as html]
            [timber.selectors :as select]
            [timber.assets :as asset]))

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

(html/deftemplate
  base-page
  "timber/templates/base.html"
  [{:keys [page-name asset-uri-path user-name main-menu user-menu page-content] :as opts}]
  select/link-asset (asset/transform-link asset-uri-path)
  select/js-asset (asset/transform-script-src asset-uri-path)
  select/main-menu (html/content main-menu)
  select/user-menu (html/content user-menu)
  select/user-name (html/content user-name)
  select/content (html/content page-content)
  
  select/link-template nil
  select/script-template nil)
