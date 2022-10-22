Criar as seguintes tabelas de acordo com a estrutura abaixo:
Seguem as descrições das tabelas:

ALUNO

MATRICULA		INT	NOT NULL,
NOME			VARCHAR (40) NOT NULL,
SOBRENOME		VARCHAR (60) NOT NULL,
ENDERECO		VARCHAR (100),
GENERO			VARCHAR (1),
DATA_NASC		DATE,
QUANT_LIVROS		INT;


AUTOR

COD_AUTOR		INT	NOT NULL,
NOME			VARCHAR (40) NOT NULL,
SOBRENOME		VARCHAR (60) NOT NULL,
GENERO			VARCHAR (1),
DATA_NASC		DATE;


LIVROS

COD_LIVRO		INT 	NOT NULL,
TÍTULO			VARCHAR (40) NOT NULL,
COD_AUTOR		INT,
STATUS_EMP		BOOLEAN;


EMPRESTIMOS

COD_EMPRESTIMO	INT	NOT NULL,
DATA			DATE,
COD_LIVRO		INT,
MATRICULA		INT,
DEVOLUCAO		BOOLEAN;


REGRAS:	

Cada aluno pode pegar emprestado no máximo 4 livros por vez;
A cada novo empréstimo, o status do empréstimo no livro deve ser alterado para verdadeiro, e quando o mesmo for devolvido, deve retornar para falso, além de acrescentar ou diminuir a quantidade de livros em posse do aluno.
Um autor pode ter vários livros, mas a biblioteca cadastra apenas um autor por livro.
Popular as tabelas com, no mínimo, 05 registros cada.
	
CONSULTAS:

a) 	Crie uma consulta que retorne a matricula, nome, sobrenome, gênero e a quantidade de livros de todos os alunos.
b)	 Crie uma consulta que retorne o nome, sobrenome e a quantidade de livros cadastrada de cada autor ordenado por nome.
c) 	Crie uma consulta que traga o nome, sobrenome e o endereço de todos os alunos com mais de 3 livros emprestados.
d) 	Crie consultas para mostrar o autor com maior quantidade de livros e o que tem a menor quantidade.
e)	Crie uma consulta que traga o nome, sobrenome e a data de nascimento de todos os alunos ordenados por data de nascimento do mais novo para o mais velho.
f) 	Escreva o comando para atualizar o cadastro do aluno MANUEL CARLOS, alterando o endereço para RUA A, Nº 1.
g)	Crie uma consulta para retornar a quantidade de livros emprestados no mês de Outubro de 2015.
h)	Crie uma consulta que traga o nome dos livros emprestados no ano de 2014 e quantas vezes cada um foi emprestado.
i)	Escreva o comando para atualizar o título do livro de: “PEQU. PRINC.” para “PEQUENO PRINCIPE”.
j)    Crie uma VIEW nomeada “LIVROS_AUTOR_EMPRESTADOS” que traga o nome do livro, o nome e sobrenome do autor, o genero do autor e a data de nascimento do autor para todos os livros emprestados.
