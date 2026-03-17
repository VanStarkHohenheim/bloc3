-- ============================================================
-- MISSION 1 - Requêtes SQL Coopain
-- Auteur : VanStarkHohenheim
-- ============================================================

-- -----------------------------------------------------------
-- Question 1.3 : Tarifs pour un taureau donné
-- -----------------------------------------------------------
-- tag::q13[]
SELECT tp.libelle, t.prixPaillette
FROM Tarif t
JOIN TypePaillette tp ON t.idTypePaillette = tp.id
WHERE t.idNationalTaureau = 'FR0103015562'
ORDER BY tp.libelle;
-- end::q13[]


-- -----------------------------------------------------------
-- Question 1.4 : Liste des taureaux triés par stock total croissant
-- -----------------------------------------------------------
-- tag::q14[]
SELECT
    t.idNational,
    t.nom,
    SUM(l.stockRestant) AS stockTotal
FROM Taureau t
LEFT JOIN Lot l ON t.idNational = l.idNationalTaureau
GROUP BY t.idNational, t.nom
ORDER BY stockTotal ASC;
-- end::q14[]
