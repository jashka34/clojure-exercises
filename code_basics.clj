(ns code-basics
  (:require [clojure.string :refer [upper-case]]))

;; *********** code-basics.com 22/50 ***********
(defn max-delta [l1 l2]
  (let [dm (fn [[x y]] (Math/abs (- x y)))
        tmpl (map list l1 l2)
        tmpd (map dm tmpl)]
    (println "1:" tmpl "2:" tmpd)
    (reduce max 0 tmpd)))

;; (defn max-delta [l1 l2]
;;   (reduce max 0 (map Math/abs (map - l1 l2))))

(max-delta '(10 -15 35) '(2 -12 42))

(defn test-max-delta []
  (assert (= 0 (max-delta '() '())))
  (assert (= 10 (max-delta '(-15) '(-5))))
  (assert (= 42 (max-delta '(0) '(42))))
  (assert (= 8 (max-delta '(10 -15 35) '(2 -12 42)))))

(test-max-delta)

;; *********** code-basics.com 21/50 ***********

(defn increment-numbers [l]
  (map inc (filter number? l)))

(defn test-increment-number []
  (assert (= (list 3 5 7) (increment-numbers (list 2 4 6))))
  (assert (= (list 11 8/5) (increment-numbers (list 10 "foo" false (list 2 3) 3/5)))))

(test-increment-number)

;; ********** code-basics.com 20/50 **********

(defn maps [fl al]
  ;; (println "m_fl" meta fl)
  ;; (println "m_al" al)
  (println "m" map fl al)
  (println "mm" (map map fl al))
  (map map fl al))

(defn test-maps []
  (let [arglist1 (list inc string?)
        arglist21 (list 10 20)
        arglist22 (list "a" 0)
        reslist1 (list 11 21)
        reslist2 (list true false)]
    (println "al1" arglist1)
    (println "al2" (list arglist21 arglist22))
    (println "rl1" reslist1 "rl2" reslist2)
    ;; (maps arglist1 (list arglist21 arglist22))
    (assert (= (list reslist1 reslist2) (maps arglist1 (list arglist21 arglist22))))))
(test-maps)

;; ********** code-basics.com 19/50 **********
(defn triple [x]
  (list x x x))

(defn test-triple []
  ;; (println "triple is" triple "a")
  (assert (= (list "a" "a" "a") (triple "a")))
  (assert (= (list 0 0 0) (triple 0)))
  (assert (= (list true true true) (triple true))))

(test-triple)

;; ********** code-basics.com 18/50 **********
(defn do-today [d]
  (println d "type is int?" (if (int? d) "int!" "not int..."))
  (println d "type is string?" (if (string? d) "string!" "not string..."))
  (println d "type is boolean?" (if (boolean? d) "boolean!" "not boolean..."))
  (cond
    (int? d) (case d (1 2 3 4 5) "work"
                   (6 7) "rest"
                   "???")
    :else "???"))

(defn test-do-today []
  (assert (= "???" (do-today false)))
  (assert (= "???" (do-today "ops")))
  (assert (= "work" (do-today 1)))
  (assert (= "work" (do-today 5)))
  (assert (= "rest" (do-today 6)))
  (assert (= "rest" (do-today 7)))
  (assert (= "???" (do-today 0)))
  (assert (= "???" (do-today -1))))

(test-do-today)

;; ********** code-basics.com 17/50 **********
(defn programmer-level [n]
  (cond
    (and (>= n 0) (<= n 10)) "junior"
    (and (>= n 11) (<= n 20)) "middle"
    :else "senior"))

(defn test-programmer-level []
  (assert (= "junior" (programmer-level 0)))
  (assert (= "middle" (programmer-level 11)))
  (assert (= "senior" (programmer-level 40))))

(test-programmer-level)

;; ********** code-basics.com 16/50 **********
(defn humanize-permission [s]
  (case s
    "x" "execute"
    "r" "read"
    "w" "write"))

[(humanize-permission "x")
 (humanize-permission "r")
 (humanize-permission "w")]

;; ********** code-basics.com 15/50 **********
(defn say-boom [s]
  (when (= s "go")
    "Boom!"))

(say-boom "hey")
(say-boom "go")

;; ********** code-basics.com 14/50 **********
(defn sentence-type [s]
  (if  (= s (upper-case s)) "cry" "common"))

(sentence-type "HOW ARE YOU?") ; "cry"
(sentence-type "Hello, world!") ; "common"

;; ********** code-basics.com 13/50 **********
(defn leap-year? [y]
  (let [r100 (= (mod y 100) 0)
        r400 (= (mod y 400) 0)
        r4 (= (mod y 4) 0)]
    (println ["y" y "r4" r4 "r100" r100 "r400" r400])
    (or (and r4 r100 r400)
        (and r4 (not (or r100 r400))))))

[(leap-year? 2012)
 (leap-year? 1913)
 (leap-year? 1804)
 (leap-year? 2100)
 (leap-year? 2000)]




