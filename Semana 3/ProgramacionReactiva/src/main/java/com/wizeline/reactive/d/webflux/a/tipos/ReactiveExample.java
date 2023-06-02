package com.wizeline.reactive.d.webflux.a.tipos;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public class ReactiveExample {
    public static void main(String[] args) {
        // Ejemplo con Flux
        Flux<Integer> numbersFlux = Flux.just(1, 2, 3, 4, 5);
        
        numbersFlux
            .map(number -> number * 2) // Transforma cada número en el flujo multiplicándolo por 2
            .filter(number -> number > 5) // Filtra los números mayores que 5
            .subscribe(System.out::println); // Imprime los números resultantes
        
        // Ejemplo con Mono
        Mono<Integer> numberMono = Mono.just(10);
        
        numberMono
            .map(number -> number + 5) // Transforma el número sumándole 5
            .flatMap(number -> {
                if (number % 2 == 0) {
                    return Mono.just("Es par");
                } else {
                    return Mono.just("Es impar");
                }
            }) // Verifica si el número es par o impar
            .subscribe(System.out::println); // Imprime el resultado
    }
}
