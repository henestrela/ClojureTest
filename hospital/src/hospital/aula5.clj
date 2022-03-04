(ns hospital.aula5
  (:use [clojure pprint])
  (:require
    [hospital.logic :as h.logic]
    [hospital.model :as h.model]))


(defn chega-em! [hospital pessoa]
  (swap! hospital h.logic/chega-em :espera pessoa))

(defn transfere! [hospital de para]
  (swap! hospital h.logic/transfere de para))

(defn simula-um-dia []
  (let [hospital (atom (h.model/novo-hospital))]
    (chega-em! hospital "joão")
    (chega-em! hospital "Maria")
    (chega-em! hospital "Danie")
    (chega-em! hospital "Gui")
    (transfere! hospital :espera :lab1)
    (pprint hospital)))

(simula-um-dia)