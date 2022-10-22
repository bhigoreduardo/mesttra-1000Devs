/* Created Database */
CREATE DATABASE hospital
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

/* Created Table enfermidade */
CREATE TABLE IF NOT EXISTS enfermidade (
	cod_enf INTEGER PRIMARY KEY,
	descricao VARCHAR(40) NOT NULL
);

/* Created Table quarto */
CREATE TABLE IF NOT EXISTS quarto (
	cod_quart INTEGER PRIMARY KEY,
	numero INTEGER NOT NULL,
	andar INTEGER NOT NULL
);

/* Created Table medico */
CREATE TABLE IF NOT EXISTS medico (
	cod_medico INTEGER PRIMARY KEY,
	nome VARCHAR(40) NOT NULL,
	sobrenome VARCHAR(60) NOT NULL,
	endereco VARCHAR(100),
	genero VARCHAR(1),
	numero_crm VARCHAR(20) NOT NULL,
	especialidade VARCHAR(60) NOT NULL,
	salario NUMERIC(9,2) NOT NULL
);