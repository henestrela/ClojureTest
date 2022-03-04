(ns hospital.colecoes
  (:use [clojure pprint]))

  (defn testa-vetor []
        (let [espera [111, 222]]
          (println espera)
          (println (conj espera 333))
          (println (pop (reverse espera)))))

(testa-vetor)

(defn testa-lista []
  (let [espera '(111, 222)]
    (println espera)
    (println (conj espera 333))
    (println (pop (reverse espera)))))

(testa-lista)


(defn testa-conjunto []
  (let [espera #{111 222}]
    (println espera)
    (println (conj espera 333))
    ;(println (pop (reverse espera))) não rola em conjunto
    ))

(testa-conjunto)


(defn testa-fila []
  (let [espera (conj clojure.lang.PersistentQueue/EMPTY "111", "222")]
    (println espera)
    (pprint (conj espera 333))
    (pprint (pop espera))
    (pprint (peek espera))
    ))
    ;(println (pop (reverse espera)))


(testa-fila)