<h1 align="center">
  📃<br>Script SQL
</h1>

<details>
<summary>✨ Conceitos</summary>

- Banco de Dados: São coleções de informações que se relacionam de forma que crie um sentido.

- Dados: Dados representam um ou mais significados que, de forma isolada, não conseguem ainda transmitir uma mensagem clara.

- Informações: São os dados devidamente tratados e analisados, produzindo conhecimento relevante.

- Conhecimento: É a informação com um contexto bem definido, processado de forma efetiva pelos profissionais.

- SGBD: Sistema de Gerenciamento de banco de dados (SGBD) é um software que incorpora e facilita as funções de definição, recuperação e alteração de dados em um Banco de Dados.

- Modelo de Organização:
## Modelo Hierárquico
![Modelo Hierárquico](assets/images/modelo-hierarquico.png)

## Modelo Rede
![Modelo Rede](assets/images/modelo-rede.png)

## Modelo Relacional
![Modelo Relacional](assets/images/modelo-relacional.png)

## Modelo Orientado a Objetos
![Modelo Orientado a Objetos](assets/images/modelo-orientado-objetos.png)

</details>

<details>
<summary>📒 Projeto de banco de dados</summary>

- Três níveis de abstração (necessário realizar o mapeamento entre os três modelos):

## Modelo Conceitual (DER)
![Modelo Conceitual (DER)](assets/images/modelo-der.png)

## Modelo Lógico (Esquema do BD)
![Modelo Lógico (Esquema do BD)](assets/images/modelo-logico.png)
## Modelo Físico (Script do BD em SQL)
![Modelo Físico (Script do BD em SQL)](assets/images/modelo-fisico.png)

## Entidades
![Entidades](assets/images/entidades.png)

## Atributos
![Atributos](assets/images/atributos.png)

## Relacionamentos
![Relacionamentos](assets/images/relationamentos.png)

## Restrições Relacionamentos

- Restrições em relacionamento: Existem 3 variações possíveis.

- 1:1 – cada instância de uma entidade relaciona-se com uma e somente uma instância da outra.

- 1:N (ou N:1) – uma instância relaciona-se com várias na outra entidade, mas cada instância da outra entidade só pode estar relacionada a uma única ocorrência da primeira entidade.

- N:N (ou N:M) – uma instância relaciona-se com várias ocorrências na outra entidade, e vice-versa.

![Restrições Relacionamentos](assets/images/restricao-relationamentos.png)

## CrowsFoot
![CrowsFoot](assets/images/crowsfoot.png)

## Grau do Relacionamento

- Grau do Relacionamento:

- Unário (grau 1): relacionamento com a própria entidade, também chamado de relacionamento recursivo ou autorrelacionamento.

- Binário (grau 2): mais comum.

- Ternário (grau 3): maior complexidade.

![Grau do Relacionamento](assets/images/grau-relacionamento.png)

## Generalização/especialização

- Generalização/especialização:

- Total (t): toda ocorrência da entidade genérica deverá estar associada a uma ocorrência de uma de suas entidades especializadas;

- Parcial (p): nem toda ocorrência da entidade genérica possui uma ocorrência em uma de suas entidades especializadas;

- Exclusiva (x): uma ocorrência de entidade genérica é especializada no máximo uma vez;

- Compartilhada (c): uma ocorrência da entidade genérica pode aparecer em várias de suas entidades especializadas.

![Generalização/especialização](assets/images/generalizacao-especializacao.png)

## Entidade associativa
![Entidade associativa](assets/images/entidade-associativa.png)

## Ferramenta brModelo
![Ferramenta brModelo](assets/images/br-modelo.png)

</details>

<details>
<summary>🗂️ Criação de Batabase</summary>
- Comunicação do Banco de Dados H2: `resources/application.properties`

    ```
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.username=sa
    spring.datasource.password=

    spring.h2.console.enabled=true
    spring.h2.console.path=/h2-console

    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    ```
</details>