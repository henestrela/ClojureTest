(ns hospital.aula1
  (:use [clojure pprint])
  (:require [hospital.model :as h.model]
            [hospital.logic :as h.logic]))

;(defn simular-um-dia []
;  ;root binding
;  (def hospital (h.model/novo-hospital))
;  (def hospital (h.logic/chega-em hospital :espera "111"))
;  (def hospital (h.logic/chega-em hospital :espera "222"))
;  (def hospital (h.logic/chega-em hospital :espera "333"))
;  (def hospital (h.logic/chega-em hospital :espera "444"))
;  (def hospital (h.logic/chega-em hospital :espera "555"))
;
;
;  (def hospital (h.logic/chega-em hospital :lab1 "444"))
;  (def hospital (h.logic/chega-em hospital :lab3 "555"))
;
;  (pprint hospital)
;
;  (def hospital (h.logic/atende hospital :lab3))
;  (pprint hospital)
;  )

(simular-um-dia)


(defn chea-em-malvado [pessoa]
  (def hospital (h.logic/chega-em-pausado hospital :espera pessoa)))

(defn simular-um-dia-emparalelo []
  (def hospital (h.model/novo-hospital))
  (.start (Thread. (fn [] (chea-em-malvado "111"))))
  (.start (Thread. (fn [] (chea-em-malvado "222"))))
  (.start (Thread. (fn [] (chea-em-malvado "333"))))
  (.start (Thread. (fn [] (chea-em-malvado "444"))))
  (.start (Thread. (fn [] (chea-em-malvado "555"))))
  (.start (Thread. (fn [] (chea-em-malvado "666"))))
  (.start (Thread. (fn [] (Thread/sleep 4000)
                          (pprint hospital))))
  )

(simular-um-dia-emparalelo)