package com.wizeline.reactive.c.librerias;

import reactor.core.publisher.Flux;

public class EjemploReactor {
    public static void main(String[] args) {
        Flux<String> flux = Flux.range(1, 10)
                .map(i -> "Evento " + i);

        flux.subscribe(
                event -> System.out.println("Evento registrado: " + event),
                Throwable::printStackTrace,
                () -> System.out.println("Proceso completado")
        );
    }
}
