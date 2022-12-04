/* Created Database */
CREATE DATABASE empresa
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

/* Created Table funcionario */
CREATE TABLE IF NOT EXISTS funcionario (
	codigo INTEGER PRIMARY KEY,
	nome VARCHAR(100),
	sobrenome VARCHAR(100),
	datanasci DATE,
	cpf VARCHAR(14),
	rg VARCHAR(10),
	endereco VARCHAR(140),
	cep VARCHAR(8),
	cidade VARCHAR(50),
	uf VARCHAR(2),
	fone VARCHAR(20),
	funcao VARCHAR(40),
	salario NUMERIC(9,2),
	codigodepartamento INTEGER
);

/* Created Table departamento */
CREATE TABLE IF NOT EXISTS departamento (
	codigo INTEGER PRIMARY KEY,
	nome VARCHAR(60),
	localizacao VARCHAR(60),
	cod_func_gerente INTEGER REFERENCES funcionario(codigo)
);

/* Added Foreign Key funcionario */
ALTER TABLE funcionario
	ADD CONSTRAINT fk_funcionario_departamento
	FOREIGN KEY (codigodepartamento) REFERENCES departamento;