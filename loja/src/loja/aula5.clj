(ns loja.aula5
  (:require [loja.db :as l.db])
  (:require [loja.logic :as l.logic]))

(defn gastou-bastantes? [info-usuario]
  (> (:preco-total info-usuario) 500))

;(let [pedidos (l.db/todos-pedidos)
;      resumo (l.logic/resumo-por-usuario pedidos)]
;    (println "keep" (keep gastou-bastantes? resumo))
;  )

(defn gastou-bastantes? [info-usuario]
  (println "gastou-bastantes?" (:usuario-id info-usuario))
  (> (:preco-total info-usuario) 500))


(let [pedidos (l.db/todos-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "keep" (keep gastou-bastantes? resumo))
  )