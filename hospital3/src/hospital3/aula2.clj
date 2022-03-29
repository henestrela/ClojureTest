(ns hospital3.aula2
    (:use clojure.pprint)
    (:require [schema.core :as s]))
;
(s/set-fn-validation! true)
;
;(s/defrecord Paciente
;    [id :- Long, nome :- s/Str])
;
;(pprint (Paciente 15 "Estrela"))

(def Paciente
    "Schema"
    {:id s/Num, :nome s/Str})

(pprint (s/explain Paciente))
(pprint (s/validate Paciente {:id 15, :nome "teste"}))

(s/defn novo-paciente :- Paciente
    [id :- s/Num, nome :- s/Str]
    { :id id, :nome nome})

(pprint (novo-paciente 15 "teste1"))

(defn estritamente-positivo? [x]
    (> x 0))

(def EstritamentePositivo (s/pred estritamente-positivo?))

;(pprint (s/validate EstritamentePositivo -10))


(def Paciente
    "Schema"
    {:id (s/constrained s/Int pos?), :nome s/Str})


(pprint (s/validate Paciente {:id -15 , :nome "teste constraint"}))