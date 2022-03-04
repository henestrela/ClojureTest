(ns hospital.aula3
    (:use [clojure pprint])
    (:require
        [hospital.logic :as h.logic]
        [hospital.model :as h.model]))


(defn teste-atomo []
    (let [hospital-silveira (atom { :espera h.model/fila_vazia})]
        (println hospital-silveira)
        (pprint hospital-silveira)
        (pprint (deref hospital-silveira))
        (pprint @hospital-silveira)
        (pprint (assoc @hospital-silveira :laboratiori1 h.model/fila_vazia))
        (pprint @hospital-silveira)

        (swap! hospital-silveira assoc  :laboratiori1 h.model/fila_vazia)
        (pprint @hospital-silveira)
        ))

(teste-atomo)