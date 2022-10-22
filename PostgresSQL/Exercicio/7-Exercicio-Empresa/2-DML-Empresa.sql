/* Insert departamento */
INSERT INTO departamento (codigo, nome, localizacao) VALUES
(1, 'Financeiro', '4º Andar'),
(2, 'Departamento Pessoal', '3º Andar'),
(3, 'TI', '2º Andar'),
(4, 'Vendas', '1º Andar');

/* Insert funcionario */
INSERT INTO funcionario VALUES
(1, 'Caped',  'Baldy', '31-12-1970', '111.111.111-11', '12345678', 'Rua A, 1', '12345678', 'Cidade Z', 'CZ', '64-3430-0001', 'Aux. Adm', 980.00, 1),
(2, 'Demon',  'Cyborg', '10-01-1972', '222.222.222-22', '12345678', 'Rua B, 1', '12345678', 'Cidade Z', 'CZ', '64-3430-0002', 'Telefonista', 980.00, 1),
(3, 'Drive', 'Knight', '13-05-1974', '333.333.333-33', '12345678', 'Rua C, 1', '12345678', 'Cidade A', 'CA', '64-3430-0003', 'Aux. Adm', 980.00, 1),
(4, 'Watchdog', 'Man', '16-08-1976', '444.444.444-44', '12345678', 'Rua D, 1', '12345678', 'Cidade A', 'CA', '64-3430-0004', 'Aux. Adm', 2000.00, 2),
(5, 'Metal', 'Bat', '19-06-1978', '555.555.555-55', '12345678', 'Rua E, 1', '12345678', 'Cidade A', 'CA', '64-3430-0005', 'Analista de Sistemas', 10000.00, 3),
(6, 'Sweet', 'Mask', '21-07-1981', '666.666.666-66', '12345678', 'Rua F, 1', '12345678', 'Cidade A', 'CA', '64-3430-0006', 'Vendedor', 3000.00, 4),
(7, 'Blue', 'Fire', '24-08-1983', '777.777.777-77', '12345678', 'Rua G, 1', '12345678', 'Cidade B', 'CB', '64-3430-0007', 'Supervisor', 9000.00, 1),
(8, 'Golden', 'Ball', '27-09-1985', '888.888.888-88', '12345678', 'Rua H, 1', '12345678', 'Cidade B', 'CB', '64-3430-0008', 'Supervisor', 9000.00, 2),
(9, 'Doll', 'Master', '02-10-1987', '999.999.999-99', '12345678', 'Rua I, 1', '12345678', 'Cidade B', 'CB', '64-3430-0009', 'Supervisor', 9000.00, 3),
(10, 'Mumen', 'Rider', '04-11-1989', '111.111.111-20', '12345678', 'Rua J, 1', '12345678', 'Cidade C', 'CC', '64-3430-0010', 'Supervisor', 9000.00, 4);

UPDATE departamento SET cod_func_gerente = 7 WHERE codigo = 1;
UPDATE departamento SET cod_func_gerente = 8 WHERE codigo = 2;
UPDATE departamento SET cod_func_gerente = 9 WHERE codigo = 3;
UPDATE departamento SET cod_func_gerente = 10 WHERE codigo = 4;