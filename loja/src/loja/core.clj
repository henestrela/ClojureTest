(ns loja.core)


(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)
    (meu-map funcao (rest sequencia))))


(meu-mapa println ["Test1" "Test2 "])

