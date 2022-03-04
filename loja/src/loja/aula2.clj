(ns loja.aula2)

(defn conta
  [total-ate-agora elementos]
  (recur (inc total-ate-agora) (rest elementos)))

;(conta 0 ["daniela" "Guilherme"])


(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora))

(println (conta 0 ["daniela" "Guilherme"]))


(defn conta
  ([elementos] (conta 0 elementos))
  ([total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora)))


(println (conta ["daniela" "Guilherme"]))


(defn conta-for
      [elementos]
      (loop [total-ate-agora 0 elementos-restantes elementos]
        (if (seq elementos-restantes)
          (recur (inc total-ate-agora) (next elementos-restantes))
          total-ate-agora)))


(println "aaa" (conta ["daniela" "Guilherme"]))
