package com.wizeline.reactive.d.webflux.c.controladores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringWebFluxExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringWebFluxExampleApplication.class, args);
    }
}

@RestController
class HelloController {
    @GetMapping("/hello")
    public Flux<String> hello() {
        return Flux.just("Hola", "Hello", "Bonjour", "Ciao", "こんにちは");
    }
}
