(ns timber.assets
  (:require [helmsman.uri :as h-uri]))

(defn- new-uri-from-match
  [public-uri match uri-attr]
    (conj public-uri
          (second
            (h-uri/path-divergance
              public-uri
              (h-uri/path
                (vec (rest (get-in match [:attrs uri-attr]))))))))

(defn transform-link
  "Creates an enlive transformation fn that re-writes link asset URIs."
  [public-uri-path]
  (fn transform-uri-fn
    [match]
    (assoc-in match [:attrs :href] (h-uri/assemble
                                    (new-uri-from-match
                                      public-uri-path
                                      match
                                      :href)))))

(defn transform-script-src
  [public-uri-path]
  (fn transform-script-src
    [match]
    (assoc-in match [:attrs :src] (h-uri/assemble
                                   (new-uri-from-match
                                     public-uri-path
                                     match
                                     :src)))))

