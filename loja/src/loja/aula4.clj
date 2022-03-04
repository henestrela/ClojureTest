(ns loja.aula4
  (:require [loja.db :as l.db])
  (:require [loja.logic :as l.logic]))


(println (l.db/todos-pedidos))

(let [pedidos (l.db/todos-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Resumo" resumo)
  (println "Ordenado" (sort-by :preco-total resumo))
  (println "Ordenado reverse" (reverse (sort-by :preco-total resumo)))
  (println "Ordenado id" (sort-by :usuario-id resumo))
  (println (get-in pedidos [0 :itens :mochila :quantidade])))


(defn resumo-usuario-ordenado-chave [pedidos chave]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by chave)
       reverse))

(let [pedidos (l.db/todos-pedidos)
      resumo (resumo-usuario-ordenado-chave pedidos :preco-total)]
  (println "Resumo" resumo)
  (println "Primeiro" (first resumo))
  (println "Second" (second resumo))
  (println "Resto" (rest resumo))
  (println "Class" (class resumo))
  (println "Total" (count resumo))
  (println "nth" (nth resumo 2))
  (println "get" (get resumo 1))
  (println "get" (take 2 resumo ))
  )


(let [pedidos (l.db/todos-pedidos)
      resumo (resumo-usuario-ordenado-chave pedidos :preco-total)]
  (println (filter #(> (:preco-total %) 100) resumo))
  (println (some #(> (:preco-total %) 100) resumo)))