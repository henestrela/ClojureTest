(ns hospital.logic)

(defn cheio? [hospital departamento]
  (-> hospital
      (get departamento)
      count
      (< 5)))

(defn chega-em [hospital departamento pessoa]
  (if (cheio? hospital departamento)
    (update hospital departamento conj pessoa)
    (throw (ex-info "Fila já está cheia" {:tentando-adicionar pessoa}))))


(defn chega-em-pausado [hospital departamento pessoa]
  (if (cheio? hospital departamento)
    (do (Thread/sleep 500)
      (update hospital departamento conj pessoa))
    (throw (ex-info "Fila já está cheia" {:tentando-adicionar pessoa}))))

(defn atende [hospital departamento]
  (update hospital departamento pop)
  )


(defn proxima
  [hospital departamento]
  (-> hospital
      departamento
      peek))

(defn transfere
  [hospital de para]
  (let [pessoa (proxima hospital de)]
    (-> hospital
        (atende de)
        (chega-em para pessoa))))



(defn atende-completo [hospital departamento]
  {:paciente (update hospital departamento peek)
   :hospital (update hospital departamento pop)})



(defn atende-completo-ambos [hospital departamento]
  (let [fila (get hospital departamento)
        peek-pop (juxt peek pop)]
        [pessoa fila] (peek-pop fila)
        {:paciente pessoa
         :hospital fila}
        ))