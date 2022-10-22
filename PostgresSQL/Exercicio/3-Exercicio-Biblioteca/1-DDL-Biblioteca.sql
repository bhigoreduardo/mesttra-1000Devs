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

/* Set Default Value aluno */
ALTER TABLE aluno
	ALTER COLUMN quant_livro SET DEFAULT 0;

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

/* Cada aluno pode pegar emprestado no máximo 4 livros por vez; */
/* Created fc_emprestar_livro */
CREATE OR REPLACE FUNCTION fc_emprestar_livro() RETURNS TRIGGER AS
$$
BEGIN
	IF ( ( ( SELECT quant_livro
		   FROM aluno
		   WHERE matricula = NEW.matricula ) >= 4 ) OR
		 ( ( SELECT status_emp
		     FROM livro
		     WHERE cod_livro = NEW.cod_livro ) != false )
	   ) THEN
	   RAISE EXCEPTION 'Não é possível realizar o empréstimo.';
	ELSE
		UPDATE aluno
			SET quant_livro = quant_livro + 1
			WHERE matricula = NEW.matricula;
		
		UPDATE livro
			SET status_emp = true
			WHERE cod_livro = NEW.cod_livro;
			
		RAISE INFO 'Empréstimo registrado.';
		
		RETURN NEW;
	END IF;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_emprestar_livro
BEFORE INSERT ON emprestimo
FOR EACH ROW EXECUTE PROCEDURE fc_emprestar_livro();