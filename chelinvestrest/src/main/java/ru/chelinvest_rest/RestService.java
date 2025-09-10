package ru.chelinvest_rest;

//import ru.chelinvest_rest.exceptions.IncorrectValueException;
//import ru.chelinvest_rest.service.NumberToTextConverter;
//import ru.chelinvest_rest.service.impl.NumberToTextConverterImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("com.grigoriy.*")
@ComponentScan("ru.chelinvest_rest.*")
@SpringBootApplication
public class RestService
{
    public static void main(String[] args) {
        // Запуск Spring Boot
        SpringApplication.run(RestService.class);
    }
}