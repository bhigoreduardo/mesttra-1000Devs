<h1 align="center">
  📃<br>Linguagem JAVA
</h1>

## 📚 Assuntos

Projeto composto por exercícios básicos em Java desenvolvidos durante o Bootcamp:

- **Assuntos/Tópicos:**:
  - Tipos de dados
  - Entrada/Saída de dados
  - Operações Matemáticas
  - Formatação de Texto
  - Conversão de tipos de dados
  - Comentário de código
  - Procedimento de código

  Classe Abstract: Não Instancia sua implementação por meio de herdeiro, somente métodos abstract são obrigatórios
Interface: Somente contrato, criando obrigação de implementar seus métodos

CREATE TABLE IF NOT EXISTS pessoa (
	numero_conta VARCHAR(60) NOT NULL,
	agencia VARCHAR(10) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
	saldo DOUBLE PRECISION NOT NULL DEFAULT 0,
	limite_cheque_especial DOUBLE PRECISION NOT NULL DEFAULT 0
);