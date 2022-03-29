(ns hospital3.aula3
    (:use clojure.pprint)
    (:require [schema.core :as s]))

(s/set-fn-validation! false)


(def PosInt (s/pred pos-int?))

(def Paciente
    "Schema"
    {:id PosInt, :nome s/Str})


(s/defn novo-paciente :- Paciente
    [id :- PosInt, nome :- s/Str]
    { :id id, :nome nome})


(pprint (novo-paciente 15 "teste1"))

(defn maior-ou-igual-a-zero? [x] (>= x 0))

(def ValorFinanceiro (s/constrained s/Num maior-ou-igual-a-zero?))


(def Plano [s/Keyword])

(def Pedido
    {:paciente Paciente
     :valor ValorFinanceiro
     :procedimento Plano})

(s/defn novo-pedido :- Pedido
    [paciente :- Paciente, valor :- ValorFinanceiro, procedimento :- s/Keyword]
    {
     :paciente paciente, :valor valor, :procedimento procedimento
    })

(pprint (novo-pedido (novo-paciente 15, "Guilherme"), 15.53, :raio-x))


(pprint (s/validate Plano [:raio-x, :implante]))