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

/* Added Constraint gerente in Table agencia */
ALTER TABLE agencia
	ADD CONSTRAINT fk_agencia_gerente
	FOREIGN KEY (gerente) REFERENCES funcionario;

/* Created Table cliente */
CREATE TABLE IF NOT EXISTS cliente (
	cod_cliente SERIAL PRIMARY KEY,
	nome VARCHAR(40) NOT NULL,
	sobrenome VARCHAR(60) NOT NULL,
	endereco VARCHAR(100),
	genero CHAR(1) NOT NULL
);

/* Created Table conta */
CREATE TABLE IF NOT EXISTS conta (
	cod_conta SERIAL PRIMARY KEY,
	cod_agencia INTEGER REFERENCES agencia,
	cod_cliente INTEGER REFERENCES cliente,
	saldo NUMERIC(9,2) NOT NULL,
	limite NUMERIC(9,2) NOT NULL
);

/* Set Default Value in Table conta Column limite */
ALTER TABLE conta
	ALTER COLUMN limite SET DEFAULT(100.00);