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