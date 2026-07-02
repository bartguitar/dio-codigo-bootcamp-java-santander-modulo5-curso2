## Esse projeto se trata de "Uma Ferramenta ou sistema de catálogo de eventos/gerenciamento de usuários/escolha de assentos para um evento (TICKETING SYSTEM)"

- USUÁRIOS - gerenciamento com banco de dados relacional
- EVENTOS - banco de dados relacional
- METADADOS DOS EVENTOS - banco NoSQL
- ASSENTOS - banco de dados relacional (postgres)
- Será usado o REDIS como mecanismo de trava, isso vai impedir que os mesmos usuários acessem o mesmo assento ao mesmo momento.
- REDIS como "caching" na parte de eventos


### TECNOLOGIAS
- Java 25
- Gradle
- Spring Data JPA (Postgres)/Mongodb/Redis
- Docker Compose

### Seção 1 - Introdução ao Conectando sua API

#### 1 - Pré-Projeto - Foi decidido não carregar o spring já antes no projeto, o projeto foi iniciado com o minimo possível de dependencias/versões/plugins, pra ir baixando e colocando as dependências de acordo com a evolução do mesmo.

```
plugins {
    id 'java'
    id 'org.springframework.boot' version '4.1.0'
    id 'io.spring.dependency-management' version '1.1.7'
}

group = 'br.com.dio'
version = '0.0.1-SNAPSHOT'
description = 'dio-projeto-modulo5-curso2-spring-data'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

tasks.named('test') {
    useJUnitPlatform()
}
```

### SEÇÃO 2 - Modelando SQL e NoSQL
ARQUITETURA - DDD

2 - Foi criada as pastas REGISTRATION - APPLICATION/DOMAIN/INFRASTRUCTURE - Ao criar essas pastas foi inserido um arquivo .gitkeep dentro de cada pasta, para subir elas para o git vazias, sem esse arquivos as pastas não subiam vazias, mas posteriormente será excluído esses arquivos.

2.1 - Esse primeiro pacote/módulo foi criado para fazer o registro de usuários
2.2 - Criação classe "Customer" e Record "CustomerId()"
2.3 - Criação da classe interface "CustomerRepository"
2.4 - Criação pacote "persistence" e dentro dele "entity, repository"
2.5 - Criação classe "JpaCustomerRepository"
2.6 - Criação do banco de dados usando Docker, criação do arquivo "compose.yml"
2.7 - Baixar a biblioteca/dependencia no build.gradle do docker para spring "developmentOnly....... 'spring-boot-docker-compose'"
2.8 - Adicionar mais 2 dependências - "Spring data JPA/mysql-connector-j"
2.9 - Testar se conectou com o banco de dados através do docker depois da criação do arquivo compose.yml e adição das dependências.
2.10 - Adicionar mais 2 dependencias - spring-boot-web/spring-boot-starter-actuator
2.11 - Testar subindo a aplicação com essas 2 dependencias já baixadas. Testar o endereço: http://localhost:8080/actuator/health
2.11 - Acrescentar 2 configurações no application.properties - "management/spring.docker"
2.12 - Testar aplicação novamente no endereço acima e confirmar se está tudo conectado ao banco de dados
2.13 - Adicionar mais 2 linhas de configuração no properties - "spring.jpa.hibernate/spring.jpa.show"
2.14 - Adicionar o plugin do "lombok"


