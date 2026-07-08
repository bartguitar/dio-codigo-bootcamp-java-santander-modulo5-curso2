package br.com.dio.dioprojetomodulo5curso2springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableCaching
public class DioProjetoModulo5Curso2SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(DioProjetoModulo5Curso2SpringDataApplication.class, args);
    }

}
