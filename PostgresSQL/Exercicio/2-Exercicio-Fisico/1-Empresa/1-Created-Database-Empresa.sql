/* Created Database empresa */
CREATE DATABASE empresa
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

/* Created Table cliente */
CREATE TABLE public.cliente
(
    id_cliente SERIAL,
    cpf VARCHAR(14),
    nome_cliente VARCHAR(150) NOT NULL,
    data_nasc_cliente DATE,
    data_cadastro_cliente DATE DEFAULT now(),
    genero_cliente VARCHAR(1),
    renda_cliente NUMERIC(9, 2),
    ativo_cliente BOOLEAN DEFAULT true,
    nivel_cliente INTEGER,

    CONSTRAINT pk_id_cliente PRIMARY KEY (id_cliente),
    CONSTRAINT unique_cpf_cliente UNIQUE (cpf),
    CONSTRAINT ck_genero_cliente CHECK (genero_cliente in ('f', 'F', 'm', 'M')),
    CONSTRAINT ck_renda_cliente CHECK (renda_cliente >= 0.00)
);

ALTER TABLE IF EXISTS public.cliente
    OWNER to postgres;

/* Created Table departamento */
CREATE TABLE IF NOT EXISTS public.departamento
(
    codigo SERIAL,
    nome VARCHAR(60) NOT NULL,
    localizacao VARCHAR(60),
    codigo_funcionario INTEGER,

    CONSTRAINT pk_codigo_departamento PRIMARY KEY (codigo),
)

ALTER TABLE IF EXISTS public.departamento
    OWNER to postgres;

/* Created Table funcionario */
CREATE TABLE IF NOT EXISTS public.funcionario
(
    codigo SERIAL,
    nome VARCHAR(60) NOT NULL,
    sobrenome VARCHAR(60) NOT NULL,
    data_nasci DATE NOT NULL,
    cpf VARCHAR(14),
    rg VARCHAR(20),
    endereco VARCHAR(120),
    cidade VARCHAR(60),
    uf VARCHAR(2),
    fone VARCHAR(10),
    codigo_departamento INTEGER,
    funcao VARCHAR(60),
    salario NUMERIC(9,2),
    cep VARCHAR(9),

    CONSTRAINT pk_codigo_funcionario PRIMARY KEY (codigo),
    CONSTRAINT unique_cpf_funcionario UNIQUE (cpf),
    CONSTRAINT unique_rg_funcionario UNIQUE (rg),
    CONSTRAINT fk_funcionario_departamento FOREIGN KEY (codigo_departamento)
        REFERENCES public.departamento (codigo) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION
)

/* Alter table departamento */
ALTER TABLE departamento
    ADD CONSTRAINT fk_departamento_funcionario
    FOREIGN KEY (codigo_funcionario)
        REFERENCES public.funcionario (codigo) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION;

/* Created Table fruta */
CREATE TABLE IF NOT EXISTS fruta_a (
	id INTEGER PRIMARY KEY,
	nome VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS fruta_b (
	id INTEGER PRIMARY KEY,
	nome VARCHAR(60) NOT NULL
);