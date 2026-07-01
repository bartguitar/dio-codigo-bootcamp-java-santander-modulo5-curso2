### TECNOLOGIAS
- Java 25
- Gradle
- Spring Boot

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

ARQUITETURA - DDD

2 - Foi criada as pastas REGISTRATION - APPLICATION/DOMAIN/INFRASTRUCTURE - Ao criar essas pastas foi inserido um arquivo .gitkeep dentro de cada pasta, para subir elas para o git vazias, sem esse arquivos as pastas não subiam vazias, mas posteriormente será excluído esses arquivos.

  
