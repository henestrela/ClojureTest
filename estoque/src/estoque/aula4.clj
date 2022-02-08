(ns estoque.aula4)

(def precos [30 700 1000])

(println (precos 0))
(println (get precos 0))
(println (get precos 2))
(println "valor padrão nil" (get precos 17))
(println "valor padrão 0" (get precos 17 0))
(println "valor padrão 0, mas existe" (get precos 2 0))


(println (conj precos 5))

(println (inc 5))

(update precos 0 inc)


(defn soma-1
  [valor]
  (println "Estou somando um em" valor)
  (+ valor 1))


(println (update precos 0 soma-1))


(defn aplica-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))


(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]

      (- valor-bruto desconto))
    valor-bruto))

(map valor-descontado precos)

(println (range 10))

(println (filter even? (range 10)))

(println "filter" (filter aplica-desconto? precos))

(reduce + precos)

(defn minha-soma
  [valor-1 valor-2]
  (+ valor-1 valor-2))

(reduce minha-soma precos)