/* Select Values pacient-medico */
SELECT paciente.nome, medico.crm
	FROM paciente
	INNER JOIN medico
    ON paciente.cpf = medico.cpf;

SELECT *
	FROM paciente
	NATURAL JOIN medico;
    
SELECT *
	FROM paciente p
    LEFT JOIN medico m
    ON p.nome = m.nome;
    
SELECT *
	FROM paciente
    FULL JOIN medico
    ON paciente.nome = medico.nome;

/* Select Values consulta */
SELECT * FROM consulta;

SELECT p.nome AS Paciente, m.nome AS Medico, c.data_consulta, c.atendimento
	FROM paciente p
    INNER JOIN consulta c
    ON p.id = c.id_paciente
    INNER JOIN medico m
    ON m.id = c.id_medico;
    
SELECT p.nome AS Paciente, m.nome AS Medico, c.data_consulta, c.atendimento
	FROM paciente p, medico m, consulta c
    WHERE p.id = c.id_paciente
    AND m.id = c.id_medico;
    
SELECT p.nome AS Paciente, p.cpf
	FROM paciente p
    INNER JOIN consulta c
    ON p.id = c.id_paciente
    INNER JOIN medico m
    ON m.id = c.id_medico
    WHERE m.crm = 'CR213';