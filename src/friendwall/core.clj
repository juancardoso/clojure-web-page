(ns friendwall.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [config.core :refer [env]]
            [rum.core :refer [defc render-static-markup]]
            [next.jdbc :as jdbc])
  (:gen-class))

; conection database config, is retrieved from config.edn file. 
(def datasource (jdbc/get-datasource (:db env)))

(defc template [headline component]
  [:div {:id "main-div"
         :class "main-page-div"}
   [:h1 headline]
   [:ul {:class "nav"}
    [:li [:a {:href "/"} "Home"]]
    [:li [:a {:href "/friends"} "Friends"]]]
   (component)])

; jdbc/execute-one! -> single result
; jdbc/execute-one! -> all result
(defc main-page []
  ; here a map is returned and greeting is turned the key and hello is the value
  (let [result (jdbc/execute-one! datasource ["SELECT 'Hello' as greeting"])]
    [:p (:greeting result)]))

(defc friends-page []
  [:p "This is the friends page, it is empty, yet"])

(defroutes app
  (GET "/" [] (render-static-markup (template "Hello, world!" main-page)))
  (GET "/friends" [] (render-static-markup (template "No friends, yet :(" friends-page))))

(defn -main
  [& args]
  (run-jetty (wrap-defaults app site-defaults) {:port (:port env)}))
