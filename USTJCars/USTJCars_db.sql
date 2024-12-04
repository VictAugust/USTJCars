CREATE DATABASE IF NOT EXISTS USTJCars_db;

USE USTJCars_db;

DROP TABLE carros; 

CREATE TABLE IF NOT EXISTS carros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    placa VARCHAR(50) NOT NULL,
    cor VARCHAR(50) NOT NULL,
    qtdLugares INT,
    quilometragem INT,
    ano INT,
    valorDiaria DECIMAL(10, 2),
    categoria VARCHAR(30),
    cambio VARCHAR(30),
    observacoes TEXT 
);