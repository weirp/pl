(ns pl.data)

(defn load-contracts []
  [{:id 1 :name "con-1" :start #inst "2017-12-01T10:00:00"},
   {:id 2 :name "con-2" :start #inst "2013-08-01T10:00:00"}])




(defn read-edn-data
  [file-path]
  (with-open [r (java.io.PushbackReader. (clojure.java.io/reader file-path))]
    (binding [*read-eval* false]
      (read r))))


(defn loadCdmsContracts [] (read-edn-data "resources/data/cdmsContracts.edn"))
(defn loadTendersContracts [] (read-edn-data "resources/data/tendersContracts.edn"))
(defn loadCdmsSuppliers [] (read-edn-data "resources/data/suppliers.edn"))
(defn loadTendersSuppliers [] (read-edn-data "resources/data/tendersSuppliers.edn"))
(defn loadTendersSuppliersByAbn [] (read-edn-data "resources/data/tendersSuppliersByAbn.edn"))

(defn buildCdmsParentChildMap [cdmsContracts]
  (reduce (fn [m data]
            (update-in m [(str (:parentcontractid data))]
                       (fn [s] (set (conj s
                                          (or (:contractid data) (:warranty data)))))))
          {}
          cdmsContracts))

(defn buildCdmsParentSupplierMap [cdmsContracts]
  (reduce (fn [m data]
            (update-in m [(str (:parentcontractid data))]
                       (fn [s] (let [suppId (:supplierid data)]
                                 (if (nil? suppId)
                                   (set (conj s (:supplierid data)))
                                   (set (conj s (:supplierid data))))))))
          {}
          cdmsContracts))

(defn buildCdmsParentContractNumberMap [cdmsContracts]
  (reduce (fn [m data]
            (update-in m [(str (:parentcontractid data))]
                       (fn [s] (let [contractNumber [(:contractid data) (:contractnumber data)]]
                                 (set (conj s contractNumber))))))
          {}
          cdmsContracts))

(defn traxData []
  [{:id 12, :contract_id 1221, :description "C1", :checked true, :date_created #inst "2014-10-19T12:00:00" },
   {:id 243, :contract_id 837, :description "C2", :checked false, :date_created #inst "2015-02-11T10:00:00" }
   ])
