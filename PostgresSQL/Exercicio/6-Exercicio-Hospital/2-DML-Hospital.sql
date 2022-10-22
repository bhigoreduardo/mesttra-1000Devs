/* Insert enfermidade */
INSERT INTO enfermidade VALUES
(1, 'Gripe'),
(2, 'Dengue'),
(3, 'Caxumba'),
(4, 'Virose'),
(5, 'Pneumonia');

/* Insert quarto */
INSERT INTO quarto VALUES
(1, 100, 1),
(2, 101, 1),
(3, 102, 1),
(4, 103, 1),
(5, 104, 1),
(6, 200, 2),
(7, 201, 2),
(8, 202, 2),
(9, 203, 2),
(10, 204, 2);

/* Insert medico */
INSERT INTO medico VALUES
(1, 'Drive', 'Knight', 'Cidade A, 1', 'F', '123456789', 'Cardiologista', 12000.00), 
(2, 'Flashy', 'Flash', 'Cidade B, 2', 'M', '123456770', 'Urologista', 11500.00),
(3, 'Watchdog', 'Man', 'Cidade A, 3', 'M', '123456780', 'Pediatra', 10000.00),
(4, 'Metal', 'Bat', 'Cidade D, 4', 'M', '123456760', 'Clinico Geral', 9000.00),
(5, 'Demon', 'Cyborg', 'Cidade Z, 5', 'M', '123456750', 'Cardiologista', 12000.00);

/* Insert paciente */
INSERT INTO paciente VALUES
(1, 'Sweet', 'Mask', 'Cidade F, 6', 'M', '01-02-1986', 1, 1),
(2, 'Death', 'Gatling', 'Cidade G, 7', 'M', '02-01-1984', 2, 1),
(3, 'Twin', 'Tail', 'Cidade H, 8', 'F', '15-12-1984', 3, 2),
(4, 'Shadow', 'Ring', 'Cidade I, 9', 'M', '22-06-1985', 4, 2),
(5, 'Blizzard', 'of Heel', 'Cidade J, 10', 'F', '19-03-1987', 5, 3),
(6, 'Caped', 'Baldy', 'Cidade A, 11', 'M', '30-07-1988', 6, 3),
(7, 'Captain', 'Mizuki', 'Cidade L, 12', 'F', '09-09-1990', 7, 4),
(8, 'Darkness', 'Blade', 'Cidade M, 13', 'M', '12-10-1989', 8, 4),
(9, 'Mumen', 'Rider', 'Cidade N, 14', 'M', '02-04-1991', 9, 5),
(10, 'Silver', 'Fang', 'Cidade O, 15', 'M', '03-11-1982', 10, 5);

/* Insert enfermidade-paciente */
INSERT INTO enfermidade_paciente VALUES
(1, 1, 1, '01-09-2015'),
(2, 2, 2, '02-09-2015'),
(3, 3, 3, '03-09-2015'),
(4, 4, 4, '04-09-2015'),
(5, 5, 5, '05-09-2015'),
(6, 6, 1, '06-09-2015'),
(7, 7, 2, '07-09-2015'),
(8, 8, 3, '08-09-2015'),
(9, 9, 4, '09-09-2015'),
(10, 10, 5, '10-09-2015');