(ns hospital.aula6
  (:use [clojure pprint])
  (:require [hospital.model :as h.model]))


(defn cheio? [fila]
  (-> fila
      count
      (< 5)))

(defn chega-em [fila pessoa]
  (if (cheio? fila)
    (conj fila pessoa)
    (throw (ex-info "Fila já está cheia" {:tentando-adicionar pessoa}))))

(defn chega-em! [hospital pessoa]
  (let [fila (get hospital :espera)]
    (ref-set fila (chega-em @fila pessoa))))

(defn chega-em! [hospital pessoa]
  (let [fila (get hospital :espera)]
    (alter fila chega-em pessoa)))

(defn simula-um-dia []
  (let [hospital { :espera (ref h.model/fila-vazia)
                   :lab1 (ref h.model/fila-vazia)
                   :lab2 (ref h.model/fila-vazia)
                   :lab3 (ref h.model/fila-vazia)}]
    (dosync (chega-em! hospital "Gui"))
    (dosync (chega-em! hospital "Gui1"))
    (dosync (chega-em! hospital "Gui2"))
    (dosync (chega-em! hospital "Gui3"))
    (dosync (chega-em! hospital "Gui4"))
    (pprint hospital)))


(simula-um-dia)

(defn async-chega-em! [hospital pessoa]
  (future (Thread/sleep (rand 5000))
          (dosync (chega-em! hospital pessoa))))