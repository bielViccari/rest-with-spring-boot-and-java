# Rest Api With Spring Boot

![GitHub repo size](https://img.shields.io/github/repo-size/bielViccari/rest-with-spring-boot-and-java)
![GitHub language count](https://img.shields.io/github/languages/count/bielViccari/rest-with-spring-boot-and-java)
![GitHub forks](https://img.shields.io/github/forks/bielViccari/rest-with-spring-boot-and-java)


> Rest Api utilizando os conceitos do Spring Boot, conexão com o banco de dados com Hibernate e JPA, e autenticação e autorização com Spring Security e JPA

### Ajustes e melhorias

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas nas seguintes tarefas:

- [x] Implementação do CRUD de person
- [x] Exceptions personalizadas
- [x] Integração com banco de dados
- [ ] busca paginada
- [ ] upload e download de arquivos
- [ ] Versionamento da API
- [ ] Migrations com Flyway
- [ ] JSON serialization
- [ ] Implementar HATEOAS
- [ ] Documentação da api com Swagger
- [ ] Configurar CORS
- [ ] Autenticação e validação com JWT e Spring Security
- [ ] testes com Junity5, Testcontainers
- [ ] Dockeirizar a api

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- Você instalou a versão 17 do `sdk java`

## 🚀 Instalando Rest Api With Spring Boot

Para instalar o Rest Api With Spring Boot, siga estas etapas:

```
git clone https://github.com/bielViccari/rest-with-spring-boot-and-java.git
```

## ☕ Usando Rest Api With Spring Boot

Para usar Rest Api With Spring Boot, siga estas etapas:
configure seu arquivo application.yml
```
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: <url para conectar ao seu banco de dados por ex: jdbc:mysql://localhost:3306/nome_da_sua_base_de_dados?useTimezone=true&serverTimezone=UTC>
    username: <username para acessar seu banco>
    password: <password para acessar seu banco>
  jpa:
    hibernate:
      ddl-auto: <tipo de comando de inicializaçao do banco de dados, por ex: update>
    properties:
      hibernate:
        dialect: <dialeto utilizado pelo hibernate, por ex o MySQL: org.hibernate.dialect.MySQLDialect>
    show-sql: false
```


## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="#" title="defina o titulo do link">
        <img src="https://avatars.githubusercontent.com/u/87938998?v=4" width="100px;" alt="Foto Gabriel Viccari no GitHub"/><br>
        <sub>
          <b>Gabriel Viccari</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
