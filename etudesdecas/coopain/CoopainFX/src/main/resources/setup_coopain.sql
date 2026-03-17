-- ============================================================
-- Script de création de la base de données pour CoopainFX
-- À exécuter dans phpMyAdmin (XAMPP)
-- ============================================================

CREATE DATABASE IF NOT EXISTS coopain
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE coopain;

-- Table des types de prestation
CREATE TABLE IF NOT EXISTS TypePrestation (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    libelle         VARCHAR(100) NOT NULL,
    prixForfaitaire FLOAT        NOT NULL
);

-- Données de test
INSERT INTO TypePrestation (libelle, prixForfaitaire) VALUES
    ('Insémination bovine',    100.00),
    ('Insémination ovine',      60.00),
    ('Echographie',             10.00),
    ('Examen de gestation',     45.00),
    ('Synchronisation cycle',   80.00);
