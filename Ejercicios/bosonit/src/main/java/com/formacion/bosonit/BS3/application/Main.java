package com.formacion.bosonit.BS3.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Main {

    @Bean
    public void func1(){
        System.out.println("Hola desde clase inicial");
    }

    @Bean
    public void func2(){
        System.out.println("Hola func2");
    }

    @Bean
    public CommandLineRunner func3(){
        return p ->{
            System.out.println("Inicio func3");
            func1();
            func2();
            System.out.println("Fin func3");
        };
    }

}
