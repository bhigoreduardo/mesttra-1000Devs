/* Insert Values in cliente */
INSERT INTO cliente (nome_cliente, data_nasc_cliente, cpf, genero_cliente, renda_cliente, nivel_cliente) VALUES
	('Galloway Roberson','2023-03-29','854-7171','F',7000,1),
	('Frederick Young','2023-06-30','524-4223','M',5000,2),
	('Perez Wolfe','2023-09-11','653-2401','M',6900,2),
	('Rodgers Ruiz','2023-03-22','65-3551','M',4590,3);

/* Insert Values in departamento */
INSERT INTO departamento (nome, localizacao, codigo_funcionario) VALUES
	('RH', 'Setor 1', 1),
	('Marketing', 'Setor 2', 2),
	('Gestão', 'Setor 3', 3),
	('Vendas', 'Setor 4', 4);

/* Insert Values in funcionario */
INSERT INTO funcionario (nome, sobrenome, data_nasci, cpf, rg, endereco, cidade, uf, fone, codigo_departamento, funcao, cep) VALUES
	('Chaney','Vinson','2023-02-11','434-8150','8707','Ap #961-3622 Eu, Street','Agder','AB','891-1253',1,'Treinador',5000.58,'58697'),
	('Hays','Morin','2023-10-08','747-8476','874443','Ap #511-6855 Fringilla Road','Banten','AB','732-7835',1,'Treinador',4600.67,'9633 NZ'),
	('Hartman','Tanner','2022-11-19','132-3616','72031','9668 Vivamus Road','Basilicata','AB','454-6512',1,'Treinador',6400.58,'8277-3158'),
	('Castillo','Phillips','2021-11-05','137-2420','8267','P.O. Box 304, 2746 Est. Rd.','Connacht','AB','361-7218',2,'Criador de artes',5000.40,'29-75'),
	('Galloway','Roberson','2023-03-29','854-7171','B9J 1G8','P.O. Box 344, 9193 Dis St.','Hải Dương','AB','661-1884',4,'CETO',7000.72,'898722'),
	('Frederick','Young','2023-06-30','524-4223','455957','Ap #600-5873 Risus, Road','Lào Cai','AB','638-5635',4,'CEO',5000.01,'16799'),
	('Perez','Wolfe','2023-09-11','653-2401','6989','5605 Nisi. Rd.','Lincolnshire','AB','779-6328',3,'Projetista',6900.45,'6534'),
	('Rodgers','Ruiz','2023-03-22','65-3551','851265','459-3085 Phasellus St.','Noord Holland','AB','766-4669',2,'Criador de artes',5500.21,'797716'),
	('Barr','Hoover','2021-12-13','218-6681','18-487','534-8051 Ac Street','West Region','AB','748-1724',3,'Projetista',2600.86,'564975'),
	('Barr','Chapman','2022-03-24','632-8318','71186','294-6262 Urna. Road','Ilocos Region','AB','273-3088',2,'Criador de artes',2100.43,'64147');

/* Insert Values in fruta */
INSERT INTO fruta_a VALUES
	(1, 'Maça'), (2, 'Abacaxi'), (3, 'Melão'), (4, 'Goiaba');
	
INSERT INTO fruta_b VALUES
	(1, 'Banana'), (2, 'Goiaba'), (3, 'Melão'), (4, 'Cereja');