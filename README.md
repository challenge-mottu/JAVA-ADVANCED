# $JAVA-ADVANCED$

# 📍 Sistema de Mapeamento de Motos em Pátio

Este projeto é uma API REST desenvolvida em Java com Spring Boot para o controle e monitoramento de motos em pátios de diferentes filiais. A solução utiliza banco de dados Oracle e segue boas práticas como uso de DTOs, paginação, ordenação, tratamento de exceções e documentação.

---

## 🚀 Funcionalidades

- Cadastro, edição, exclusão e listagem de motos
- Associação com dispositivos IoT
- Busca por parâmetros (ex: placa, status)
- Paginação e ordenação
- Validações e tratamento de erros
- API documentada (Swagger/OpenAPI)
- Pronta para integração com front-end (ex: React Native)

---

## 📦 Tecnologias Utilizadas

- Java 21
- Spring Boot 3+
- Spring Data JPA
- Oracle Database
- Hibernate Validator
- Maven

---

## 🗂 Estrutura do Projeto Java

```
mottu/
├── .gitattributes
├── .gitignore
├── compose.yaml
├── HELP.md
├── mvnw / mvnw.cmd
├── pom.xml
├── .idea/
├── .mvn/wrapper/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/challenge/mottu/
│   │   │       ├── MottuApplication.java
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       ├── entity/
│   │   │       ├── exception/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/
│           └── br/com/challenge/mottu/
│               └── MottuApplicationTests.java

```

## 🗂 Estrutura das Entidades Principais

- `Moto` — representa a moto que está no pátio
- `DispositivoIoT` — representa o dispositivo de rastreamento associado
- `Filial`, `Pátio`, `ReceptorWifi`, `RFID`, `PosicaoMoto` — entidades auxiliares do modelo

---

## ⚙️ Como executar o projeto

### 1. Pré-requisitos

- Java instalado
- Maven instalado
- Oracle Database em execução
- IDE recomendada: IntelliJ IDEA ou Eclipse

### 2. Configurar o `application.properties`

No arquivo `src/main/resources/application.properties`, configure as credenciais do Oracle:

```properties
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/XEPDB1
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
