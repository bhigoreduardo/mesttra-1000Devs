/* Created Database */
CREATE DATABASE agencia_bancaria
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

/* Created Table agencia */
CREATE TABLE IF NOT EXISTS agencia (
	cod_agencia SERIAL PRIMARY KEY,
	nome VARCHAR(140) NOT NULL,
	endereco VARCHAR(140) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
	gerente INTEGER NOT NULL
);

/* Created Table funcionario */
CREATE TABLE IF NOT EXISTS funcionario (
	cod_funcionario SERIAL PRIMARY KEY,
	nome VARCHAR(140) NOT NULL,
	cod_agencia INTEGER REFERENCES agencia
);