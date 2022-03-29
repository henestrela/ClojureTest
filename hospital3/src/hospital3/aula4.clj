(ns hospital3.aula4
    (:use clojure.pprint)
    (:require [schema.core :as s]))

(s/set-fn-validation! false)


(def PosInt (s/pred pos-int?))

(def Plano [s/Keyword])

(def Paciente
    "Schema"
    {:id           PosInt,
     :nome         s/Str,
     :plano        Plano
     (s/optional-key :nascimento) s/Str})


(pprint (s/validate Paciente {:id 15, :nome "Hen", :plano nil}))

(def Pacientes
    {PosInt Paciente})

