(ns hospital2.aula1
  (:use clojure.pprint))

(defn adiciona-paciente
  [pacientes paciente]
  (let [id (:id paciente)]
    (assoc pacientes id paciente)))

(defrecord Paciente [id nome nascimento])

(->Paciente 15 "Guilherme" "18/09/1981")