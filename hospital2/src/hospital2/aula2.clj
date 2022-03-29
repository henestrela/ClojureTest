(ns hospital2.aula2
  (:use clojure.pprint))

(defrecord PacienteParticular [id, nome, nascimento])
(defrecord PacientePlanoSaude [id, nome, nascimento, plano])

(defprotocol Cobravel
  (deve-assinar? [paciente procedimento valor]))


(extend-type PacienteParticular
  Cobravel
  (deve-assinar? [paciente procedimento valor]
    (>= valor 50)))

(extend-type PacientePlanoSaude
  Cobravel
  (deve-assinar? [paciente procedimento valor]
    (let [plano (:plano paciente)]
        (not (some #(= % procedimento) plano)))))

(let [particular (->PacienteParticular 15, "h", "15/15/1598")
      plano (->PacientePlanoSaude, 16, "g", "14/14/1419", [:raio-x, :ultrasom])]
  (pprint (deve-assinar? particular, :raio-x, 500))
  (pprint (deve-assinar? particular, :raio-x, 40))
  (pprint (deve-assinar? plano, :raio-x, 40))
  (pprint (deve-assinar? plano, :coleta, 40)))