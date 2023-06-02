package com.wizeline.reactive.d.webflux.b.combinacion;

import java.io.Serializable;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveCombinationExample {
    public static void main(String[] args) {
        // Ejemplo de combinación de dos Flux y un Mono
        Flux<String> colorsFlux = Flux.just("Rojo", "Verde", "Azul");
        Flux<Integer> numbersFlux = Flux.range(1, 3);
        Mono<String> animalMono = Mono.just("León");

        // Se detiene cuando uno de los flujos deja de emitir mensajes
        Flux<String> combinedFlux = Flux.zip(colorsFlux, numbersFlux, animalMono)
                .map(data -> data.getT1() + "-" + data.getT2() + "-" + data.getT3());

        // Combina los flujos uno tras otro
        Flux<? extends Serializable> mergedFlux = Flux.merge(colorsFlux, numbersFlux, animalMono);

        System.out.println("Zip output");
        combinedFlux.subscribe(System.out::println);

        System.out.println("Merge output");
        mergedFlux.subscribe(System.out::println);
    }
}
