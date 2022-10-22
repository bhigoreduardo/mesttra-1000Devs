/* Created database */
CREATE DATABASE biblioteca
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

/* Created Table aluno */
CREATE TABLE IF NOT EXISTS aluno (
	matricula SERIAL PRIMARY KEY,
	nome VARCHAR(40) NOT NULL,
	sobrenome VARCHAR(60) NOT NULL,
	endereco VARCHAR(100),
	genero CHAR(1),
	data_nasc DATE,
	quant_livro INTEGER
);

/* Created Table autor */
CREATE TABLE IF NOT EXISTS autor (
	cod_autor SERIAL PRIMARY KEY,
	nome VARCHAR(40) NOT NULL,
	sobrenome VARCHAR(60) NOT NULL,
	genero CHAR(1),
	data_nasc DATE,
	cpf VARCHAR(14) NOT NULL UNIQUE
);

/* Created Table livro */
CREATE TABLE IF NOT EXISTS livro (
	cod_livro SERIAL PRIMARY KEY,
	titulo VARCHAR(40) NOT NULL,
	cod_autor INTEGER NOT NULL REFERENCES autor,
	status_emp BOOLEAN DEFAULT false
);

/* Created Table emprestimo */
CREATE TABLE IF NOT EXISTS emprestimo (
	cod_emprestimo SERIAL PRIMARY KEY,
	data DATE NOT NULL DEFAULT (CURRENT_DATE),
	cod_livro INTEGER NOT NULL REFERENCES livro,
	matricula INTEGER NOT NULL REFERENCES aluno,
	devolucao BOOLEAN DEFAULT false
);