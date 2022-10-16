<h1 align="center">
  📃<br>Script SQL
</h1>

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