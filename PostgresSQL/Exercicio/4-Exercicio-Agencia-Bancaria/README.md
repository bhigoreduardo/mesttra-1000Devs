De acordo com a estrutura do banco de dados abaixo elabore as consultas: 
Seguem as descrições das tabelas:

AGÊNCIA
CÓD_AGENCIA		INT PRIMARY KEY,
NOME			VARCHAR (140) NOT NULL,
ENDERECO		VARCHAR(140) NOT NULL.
TELEFONE		VARCHAR(20) NOT NULL
GERENTE			INT FOREIGN KEY

FUNCIONÁRIOS
COD_FUNCION		INT 	PRIMARY KEY NOT NULL,
NOME			VARCHAR(140) NOT NULL,
COD_AGENCIA		INT FOREIGN KEY

CLIENTES
COD_CLI			INT PRIMARY KEY,
NOME			VARCHAR (40) NOT NULL,
SOBRENOME		VARCHAR (60) NOT NULL,
ENDERECO		VARCHAR (100),
GENERO			VARCHAR (1)

CONTAS
COD_CONTA		INT PRIMARY KEY,
COD_AGENCIA		INT FOREIGN KEY,
COD_CLI			INT FOREIGN KEY,
SALDO			NUMERIC(9,2) NOT NULL,
LIMITE			NUMERIC(9,2) NOT NULL

SAQUES
COD_SAQUE	 	INT PRIMARY KEY,
DATA_SAQUE		DATE NOT NULL,
COD_CONTA		INT FOREIGN KEY,
VALOR_SAQUE		NUMERIC(9,2) NOT NULL

DEPOSITOS
COD_DEPOSITO	 	INT PRIMARY KEY,
DATA_DEPOSITO	DATE NOT NULL,
COD_CONTA		INT FOREIGN KEY,
VALOR_DEPOSITO	NUMERIC(9,2) NOT NULL

TRANSFERENCIAS
COD_TRANSF	 	INT PRIMARY KEY,
DATA_TRANSF		DATE NOT NULL,
COD_CONTA_DEB	INT FOREIGN KEY,
COD_CONTA_CRED	INT FOREIGN KEY,
VALOR_TRANSF		NUMERIC(9,2) NOT NULL

Regras de negócio:

Quando for cadastrar uma nova conta o limite inicial sempre deverá ser de R$ 100,00.
Quando um cliente for efetuar um saque o sistema deve verificar se existe saldo suficiente para realizar o saque.
Quando for feito um depósito o valor depositado deve ser acrescentado ao saldo da conta do cliente.
Quando for feita uma transferência é necessário verificar se existe saldo na conta que receberá o débito e, caso exista o saldo, efetuar o crédito na conta destinatária.
Quando o limite da conta for alterado, o sistema deve verificar se o novo limite não é inferior ao saldo atual.
