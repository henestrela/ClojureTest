(ns hospital.aula4
  (:use [clojure pprint])
  (:require
    [hospital.logic :as h.logic]
    [hospital.model :as h.model]))


(defn chega-sem-malvado! [hospital pessoa]
  (swap! hospital h.logic/chega-em :espera pessoa)
  (println "apos inserir" pessoa))


(defn start-thread
  [hospital pessoa]
  (.start (Thread. (fn [] (chega-sem-malvado! hospital pessoa)))))

(defn simula-um-dia-partial
  []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas  ["111","222","333", "444", "555", "666"]
        starta (partial start-thread hospital)]

    (mapv starta pessoas)

    (.start (Thread. (fn [] (Thread/sleep 5000)
                       (pprint hospital))))))

;(simula-um-dia-partial)


(defn simula-um-dia-partial-doseq
  []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas  ["111","222","333", "444", "555", "666"]]

    (doseq [pessoa pessoas] (start-thread hospital pessoa))

    (.start (Thread. (fn [] (Thread/sleep 5000)
                       (pprint hospital))))))

(simula-um-dia-partial)