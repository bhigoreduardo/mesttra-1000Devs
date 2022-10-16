/* Created Database hospital */
CREATE DATABASE hospital;

/* Created Table paciente */
CREATE TABLE IF NOT EXISTS paciente (
	id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL,
    CONSTRAINT chk_data_nascimento CHECK (data_nascimento <= NOW())
);

/* Created Table consulta */
CREATE TABLE IF NOT EXISTS consulta(
	id_paciente INTEGER NOT NULL,
    id_medico INTEGER NOT NULL,
    data_consulta DATE NOT NULL,
    atendimento VARCHAR(255) NOT NULL,
    
    PRIMARY KEY (id_paciente, id_medico, data_consulta)
);

/* Created Table medico */
CREATE TABLE IF NOT EXISTS medico (
	id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL,
    crm VARCHAR(30) UNIQUE NOT NULL,
    CONSTRAINT chk_data_nascimento CHECK (data_nascimento < NOW())
);

/* Insert Values in paciente */
INSERT INTO paciente (nome, cpf, data_nascimento) VALUES
	('Saitama', '9999999', '1990/01/01'),
	('Genos', '1233123', '1999/01/10'),
	('Garou', '122222', '2000/01/20');

/* Insert Values in medico */
INSERT INTO medico (nome, cpf, data_nascimento, crm) VALUES
('Silverfagn', '123339', '1800/01/01', 'CR213'),
('Genos', '1233123', '1999/01/10', 'CR43'),
('Blast', '122332', '1980/01/20', 'CR90');

INSERT INTO consulta VALUES
	(1, 1, '2022/10/14', 'Atendimento no consultório'),
	(1, 2, '2022/10/14', 'Atendimento na sala'),
	(2, 1, '2022/10/13', 'Atendimento no consultório');