(ns estoque.aula6)

(def pedido {:mochila  {:qtd 2, :prc 80}
             :camiseta {:qtd 3, :prc 40}})

(defn imprime-e-15 [valor]
  (println "valor" (class valor) valor)
  15)


(println (map imprime-e-15 pedido))


;(defn imprime-e-15 [chave valor]
;  (println chave "e" valor)
;  15)
;
;(println (map imprime-e-15 pedido))

;Jeito certo de desestruturar um vetor
(defn imprime-e-15 [[chave valor]]
  (println chave "e" valor)
  15)

(println (map imprime-e-15 pedido))


(defn preco-por-produto [[_ valor]]
  (* (:qtd valor) (:prc valor)))

(println (map preco-por-produto pedido))

(println (reduce + (map preco-por-produto pedido)))


(defn total-do-pedido
  [pedido]
  (reduce + (map preco-por-produto pedido)))

(println (total-do-pedido pedido))

;threadlats

(defn total-do-pedido
  [pedido]
  (->> pedido
       (map preco-por-produto)
       (reduce +)))


(println (total-do-pedido pedido))


(defn preco-total-do-produto [produto]
  (* (:qtd produto) (:prc produto)))

;threadlats

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +)))

(def pedido {:mochila  {:qtd 2, :prc 80}
             :camiseta {:qtd 3, :prc 40}
             :chaveiro {:qtd 1}})


(defn gratuito?
  [[_ item]]
  (<= (get item :prc 0) 0))

(println (filter gratuito? pedido))



(defn gratuito?
  [item]
  (<= (get item :prc 0) 0))

(println (filter #(gratuito? (second %)) pedido))

(defn pago?
  [item]
  (not (gratuito? item)))

(println
  (pago? {:prc 0}))

(println ((comp not gratuito?) {:prc 0}))


(def pago? (comp not gratuito?))

(println (pago? {:prc 50}))