(ns csv-to-db
  (:require [clojure.java.io :as io]
            ;; [clojure.data.csv :as csv]
            ;;[babashka.pods :as pods]
            [next.jdbc :as jdbc]
            ;; [next.jdbc.sql :as sql]
            ;; [java-time :as jt]
            ))

;; 1. Чтение настроек из файла .dbcredentials
(defn read-db-credentials []
  (let [creds (-> ".dbcredentials" io/reader slurp read-string)]
    {:dbtype "oracle"
     :host (:host creds)
     :dbname (:dbname creds)
     :port (:port creds)
     :user (:user creds)
     :password (:password creds)}))

;; (def db-creds0 (read-db-credentials))
;; (println "db-creds0:" db-creds0)
;; (def ds (jdbc/get-datasource db-creds0))
;; (println "ds:" ds)
;; (sql/execute! db-creds0 ["select * from dual"])
;; (println "execute ok")

;; 2. Получение имени CSV-файла из параметра командной строки
;; (def csv-file-name "f1.csv" ;(first *command-line-args*)
;;   )

;; 3. Чтение CSV-файла в вектор
;; (defn read-csv [file]
;;   (with-open [reader (io/reader file)]
;;     (->> (csv/read-csv reader :separator \;)
;;          (#(do (println "data" %) (vec %)))
;;          (drop 1)
;;          (map-indexed (fn [idx# row#]
;;                         ;; (println "Строка:" (inc idx#) "Данные:" row#)
;;                          ;; Преобразуем строку в мапу
;;                         {:id (inc idx#)
;;                          :col1 (Long/parseLong (first row#))
;;                          :col2 (second row#)
;;                          :col3 (nth row# 2)})))))
;;
;; 4. Вставка данных в таблицу
;; (defn insert-data [ds data]
;;   (doseq [row data]
;;     (sql/insert! ds :your_table_name row)))

;; 5. Обновление данных в таблице
;; (defn update-data [ds data]
;;   (doseq [row data]
;;     (let [new-date (jt/plus (:col2 row) (jt/days 1))]
;;       (sql/update! ds :your_table_name
;;                    {:col2 new-date}
;;                    ["col1 = ?" (:col1 row)]))))

;; Основная функция
(defn -main []
  (println "go -main")
  (let [db-creds (read-db-credentials)
        ;; ds (jdbc/get-datasource db-creds)
        ;; ds (db db-creds)
        ;; data (read-csv csv-file-name)
        ]
    (println "db creds:" db-creds)
    ;; (println "file:" data)
    ;; Вставка данных
    ;; (insert-data ds data)
    ;; Обновление данных
    ;; (update-data ds data)
    ))
;; Запуск
(-main)
