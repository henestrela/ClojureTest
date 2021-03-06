(ns hospital3.aula1
  (:use clojure.pprint)
  (:require [schema.core :as s])
  )

(defn adiciona-paciente
  [pacientes, paciente]
  (if-let [id (:id paciente)]
    (assoc pacientes id paciente)
    (throw (ex-info "Paciente não possui id" {:paciente paciente}))))

(defn adiciona-visita
  [visitas, paciente, novas-visitas]
  (if (contains? visitas paciente)
    (update visitas paciente concat novas-visitas)
    (assoc visitas paciente novas-visitas))
  )

(defn imprime-relatorio-paciente [visitas, paciente]
  (println "Visitas do paciente" paciente "são" (get visitas paciente)))

(defn testa-uso-de-pacientes []
  (let [guilherme {:id 15, :nome "Guilherme"}
        daniela {:id 20, :nome "Daniela"}
        paulo {:id 25, :nome "Paulo"}
        pacientes (reduce adiciona-paciente {} [guilherme, daniela, paulo])
        visitas {}
        visitas (adiciona-visita visitas 15 ["01/01/2022"])
        visitas (adiciona-visita visitas 20 ["02/01/2022", "02/02/2022"])
        visitas (adiciona-visita visitas 15 ["03/01/2022"])]
    (pprint pacientes)
    (imprime-relatorio-paciente visitas 15)))

(testa-uso-de-pacientes)

(s/set-fn-validation! true)


(s/defn imprime-relatorio-paciente [visitas, paciente :- long]
  (println "Visitas do paciente" paciente "são" (get visitas paciente)))

(testa-uso-de-pacientes)

