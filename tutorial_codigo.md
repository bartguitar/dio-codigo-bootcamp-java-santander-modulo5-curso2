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
- Teste de API - http://localhost:8080/explorer/index.html#uri=/

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

2.1 - Esse primeiro pacote/módulo foi criado para fazer o registro de usuários \
2.2 - Criação classe "Customer" e Record "CustomerId()" \
2.3 - Criação da classe interface "CustomerRepository" \
2.4 - Criação pacote "persistence" e dentro dele "entity, repository" \
2.5 - Criação classe "JpaCustomerRepository"\
2.6 - Criação do banco de dados usando Docker, criação do arquivo "compose.yml" \ 
2.7 - Baixar a biblioteca/dependencia no build.gradle do docker para spring "developmentOnly....... 'spring-boot-docker-compose'" \
2.8 - Adicionar mais 2 dependências - "Spring data JPA/mysql-connector-j"\
2.9 - Testar se conectou com o banco de dados através do docker depois da criação do arquivo compose.yml e adição das dependências. \
2.10 - Adicionar mais 2 dependencias - spring-boot-web/spring-boot-starter-actuator\
2.11 - Testar subindo a aplicação com essas 2 dependencias já baixadas. Testar o endereço: http://localhost:8080/actuator/health\ \
2.11 - Acrescentar 2 configurações no application.properties - "management/spring.docker" \
2.12 - Testar aplicação novamente no endereço acima e confirmar se está tudo conectado ao banco de dados \
2.13 - Adicionar mais 2 linhas de configuração no properties - "spring.jpa.hibernate/spring.jpa.show" \
2.14 - Adicionar o plugin do "lombok" \
--Feito commit-- \
2.15 - Criar classe "Customer" dentro de entity e fazer anotações da classe, "@Entity/@Data/@RequiredArgsConstructor" \
2.16 - Terminar de fazer a classe "Customer" do pacote entity \
2.17 - Adicionar dependência "spring-boot-validation" \
2.18 - Fazer anotações em "Customer/pacote entity" @NotBlank e @Column e demais anotações da classe\
2.19 - Subir a aplicação e ver se foi criado a estrutura do banco \
--Feito commit-- \
2.20 - Criar a interface "CustomerEntityRepository" \
2.21 - injeção de dependencia no "JpaCustomerRepository" dentre outros codigos/metodos da classe \
2.22 - Marcar anotação do lombok "@Getter" no "Customer pacote Domain" \
2.23 - Implementação de vários codigos em "JpaCustomerRepository" \
2.24 - Exclusão dos arquivos .gitkeep para limpeza das pastas \
--Feito commit-- 
### Seção 3 - Criando API REST para Customers
3 - Adicionar dependência "spring-data-rest" \
3.1 - Adicionar anotação dentro de "CustomerEntityRepository" \
3.2 - Mais uma extensão da interface "CustomerEntityRepository" chamada "PagingAndSorting....." \
3.3 - Adicionar dependencia "hal-explorer" - Teste endereço: http://localhost:8080/explorer/index.html#uri=/ \
3.4 - Criar metodo "public void prePersist" em "entity/customer" \
3.5 - Alteração no "application.properties" - ao inves de "create", colocar "update" \
--Feito commit-- \
3.6 - Alterar a classe "CustomerEntityRepository" para não expor o delete ("void delete by id") e criar uma lista de consulta \
3.7 - Fazer integração com endereço criando a classe "entity/Address" \
3.8 - Voltar classe "entity/customer" e fazer mapeamento e relacionamentos com de classe endereço \
3.9 - Criar pacote "entity/projection" e criar interface "CustomerExcerpt" dentro desse pacote \
3.10 - Alterar "CustomerEntityRepository" com "excerptProjection" como parametro \
3.11 - Criar pacote "infrastructure/event" e criar classe "CustomerEventHandler" \
--Feito commit-- 
### Seção 4 - Flexibilidade com NoSQL
4.1 - Começar um novo componente, criar pacote "catalog" \
4.2 - Inserir "catalog-database" no arquivo "compose.yml" \
4.3 - Inserir "catalog-data" no "compose.yml" \
4.4 - Inserir em "application.properties" várias propriedades - # Registration (MySQL 3307) e # Catalog (MySQL 3308) \
4.5 - Excluir dentro de "properties" linhas - "spring.jpa.hibernate.ddl-auto=update/spring.jpa.show-sql=true" \
4.6 - Criar classe "RegistrationConfiguration" \
4.7 - Criar classe "CatalogConfiguration" \
4.8 - Criar dentro de "catalog", pacotes "application/domain/infrastructure" \
4.9 - Criar dentro de "catalog/infrastruture" pacotes "persistence" e dentro dele "entity/repository" \
4.10 - Criar dentro de "catalog/infrastructure/entity" classe "Event" \
4.11 - Criar pasta "event" dentro de "catalog/infrastruture" e criar classe "EventListener" \
4.12 - Criar dentro de "catalog/infrastructure/persistence/repository" criar interface "EventEntityRepository" \
--Feito commit-- 
### Seção 5 - Multi-Database com Docker
5.1 - Criar banco de dados mongo-db "catalog-metadata-database" no arquivo "compose-yml" \
5.2 - Testar se subiu o banco do mongo-db criado \
5.3 - Adicionar nova dependência "spring-data-mongodb" em "build.gradle" \
5.4 - Adicionar as configurações do mongo-db dentro da classe "CatalogConfiguration" colocando as anotações \
5.5 - Criar dentro de "catalog/infra/persis/entity" classe "EventMetadata" \
5.6 - Adicionar config dentro de "application.properties" o mongodb 'spring.mongodb.representation' \
5.7 - Criar interface "EventMetadataEntityRepository" dentro de "catalog/repository" \ 
5.8 - Criar classe "EventMetadataEventListener" dentro de "catalog/infra/event" \
--Feito commit--
### Seção 6 - Criando Endpoints Customizados
6.1 - Criar classe "Event" em "catalog/domain" \
6.2 - Criar record "EventId" \
6.3 - Criar record "EventMetadata" \
6.4 - Criar record "SectorId" \
6.5 - Criar classe "Sector" \
6.6 - Criar record "SeatId" \
6.7 - Criar classe "Seat" \
6.8 - Criar interface "EventRepository" \
6.9 - Criar interface "EventMetadataRepository" \
--Feito commit-- \
6.10 - Criar classe "JpaEventRepository" dentro de "catalog/infra/persist../repository" \
6.11 - Criar classe "MongoEventMetadataRepository" \
--Feito commit-- \
6.12 - Criar classe "BrowseShowcaseUseCase" em "catalog/application" \
6.13 - Excluir o import "import br.com.dio.dioprojetomodulo5curso2springdata.catalog.infrastructure.persistence.entity.EventMetadata;"
da classe "catalog/domain/Event" \
6.14 - Criar pacote "http" em "catalog/infra" \
6.15 - Criar classe "ShowcaseController" em "http" \
6.16 - Entrar com nova funcionalidade do java 21 "Virtual Threads" adicionando em "properties" a config "spring.threads" \
6.17 - Colocar a anotação "EnableAsync" na classe main do projeto \
6.18 - Criar a classe "EventEnricher" e alterar classe "BrowserShowcaseUseCase" \
6.19 - Criar pacote "dto" em "catalog/application" e dentro criar a classe record "EventOutput" \
6.20 - Alterar classe "ShowcaseUseCase" colocar lista de "<EventOutput>" \
6.21 - Alterar "catalog.jpa.properties.hibernate.hbm2ddl.auto=create" para "update" \
--Feito commit--
### Seção 7 - Implementando Redis com Spring Data
7.1 - Criar em "compose.yml" o banco "catalog-cache" \
7.2 - Adicionar duas dependências "spring-boot-redis" e "redis.clients" \
7.3 - Adicionar em "application.properties" a config "spring.data.redis..." \
7.4 - Colocar a anotação "EnableCaching" na classe main \
7.5 - Alterar classe "BrowseShowcaseUseCase" fazer anotação de "@cacheable" \
7.6 - Alterar classe "EventOutput" colocar "implements Serializable" \
7.7 - Testar aplicação, se der erro de "CacheManager", adicioná-lo manualmente em "CatalogConfiguration" método "redisCacheManager" \
--Feito commit--
### Seção 8 - Comunicação entre Microsserviços
8.1 - Criar novo componente/pacote "ticketing" \
8.2 - Criar novo pacote "common/infrastructure/event/dto" \
8.3 - Criar classe record "CustomerCreated" \
8.4 - Alterar classe "CustomerEventHandler" \
8.5 - Alterar classe "JpaCustomerRepository" \
8.6 - Criar classe record "EventUpdated" \
8.7 - Alterar classe "EventMetadataEventListener" \
8.8 - Dentro de "ticketing" criar 3 pacotes "application, domain, infrastructure" \
8.9 - Dentro de "infra" criar pacote "event" \
8.10 - Criar classe "TicketingEventListener" dentro de "event" \
8.11 - Testar aplicação \
--Feito commit--
### Seção 9 - Implementando Persistência com Postgres
9.1 - Criar o banco "ticketing-database" postgres em "compose.yml" \
9.2 - Testar se subiu o banco criado "ticketing-database" \
9.3 - Adicionar dependência do postgres "org.postgres...." em "build.gradle" \
9.4 - Adicionar config "ticketing (postgres 5433)" em "application.properties" \
9.5 - Criar classe "TicketingConfiguration" \
9.6 - Criar "CustomerId" dentro de "ticketing/domain" \
9.7 - Dentro de "ticketing/domain" classe "Customer" \
9.8 - Dentro de "ticketing/domain" classe interface "CustomerRepository" \
9.9 - Criar dentro de "ticketing/application" classe "CreateCustomerUseCase" \
9.10 - Alterar classe "TicketingEventListener" \
9.11 - Criar pacote "persistence" dentro de "ticketing/infra" \
9.12 - Criar pacote "entity" e "repository" \
9.13 - Criar classe "Customer" \
9.14 - Criar classe interface "CustomerCrudRepository" \
9.15 - Criar classe "PostgresCustomerRepository" \
9.16 - Testar aplicação \
9.17 - Alterar classe interface "CustomerCrudRepository" parametro "path = "_customer" \
9.18 - Fazer POST em "customers" para testar entrada de dados na api em http://localhost:8080/explorer/index.html#uri=/ \
9.19 - Criar classe "Event" dentro de "ticketing/domain" \
9.20 - Criar classe "EventId" \
9.21 - Criar classe "SectorId" \
9.22 - Criar classe "Sector" \
9.23 - Criar classe "SeatId" \
9.24 - Criar classe "Seat" \
9.25 - Criar classe interface "EventRepository" \
9.26 - Criar classe "CreateEventUseCase" dentro de "/ticketing/application" \
9.27 - Alterar classe "TicketingEventListener" injetar "CreateEventUseCase" \
9.28 - Criar classe "Event" dentro de "ticketing/entity" \
9.29 - Criar classe "Sector" dentro de "ticketing/entity" \
9.30 - Criar classe "Seat" dentro de "ticketing/entity" \
9.31 - Criar classe interface "EventCrudRepository" \
9.32 - Criar classe "PostgresEventRepository" \
9.33 - Testar aplicacao api http://localhost:8080/explorer/index.html#uri=/ \
9.34 - Confirmar se todas as tabelas atualizadas foram para o postgres \
--Feito commit--
### Seção 10 - Evitando Overbooking (Criando regra de negócio nova)
10.1 - Subir mais uma instância do REDIS no "compose.yml" chamada "ticketing-locking" \
10.2 - Adicionar config em properties "catalog.redis.host"/"catalog.redis.port" e "ticketing.redis.host"/"ticketing.redis.port \
10.3 - Adicionar em "CatalogConfiguration" método "catalogRedisConnectionFactory" \
10.4 - Adicionar 2 métodos "RedisConnection" em "TicketingConfiguration" \
10.5 - Testar Aplicação \
10.6 - Criar classe "SeatLock" \
10.7 - Criar classe interface "RedisSeatLockRepository" \
10.8 - Alterar classe "EventRepository" adicionar metodos "existsSeat" e "tryLockSeat" \
10.9 - Alterar nome da classe "PostgresEventRepository" para "WorkOfUnitEventRepository" \
10.10 - Implementar na classe "WorkOfUnitEventRepository" os 2 metodos criados anteriormente no item 10.8 e injetar variavel "redisSeatLockRepository" \
10.11 - Criar metodo "existsByCorrelationIdAndSectors_Seats_CorrelationId" em "EventCrudRepository" \
10.12 - Criar classe "SelectSeatUseCase" \
10.13 - Criar classe exception "SeatNotFoundException" \
10.14 - Criar classe exception "SeatAlreadyReservedException" \
10.15 - Criar pasta "http" e "SeatSelectionController" \
10.16 - Criar pasta "request" dentro de "http" e criar classe "SeatSelectionRequest" \
10.17 - Subir e Testar aplicação (criar no Hall Explorer), criar tudo do zero seguindo os passos do topico seguinte \
10.18 - Criar - Usuário > Criar um evento > Criar evento de atualização
--Feito Commit--
