(ns hospital.core
  (:use [clojure pprint])
  (:require [hospital.model :as h.model]))


(let [h-henrique (h.model/novo-hospital)]
  (pprint h-henrique))


