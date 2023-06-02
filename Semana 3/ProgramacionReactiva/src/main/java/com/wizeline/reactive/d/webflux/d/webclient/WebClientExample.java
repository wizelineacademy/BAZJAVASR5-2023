package com.wizeline.reactive.d.webflux.d.webclient;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WebClientExample {

    public static void main(String[] args) {
        WebClient webClient = WebClient.create();

        Mono<String> response = webClient.get()
                .uri("https://pokeapi.co/api/v2/pokemon/ditto")
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToMono(String.class);

        response.subscribe(System.err::println);

        // Si no esperamos, como la ejecución ocurre asíncronamente, no podremos ver el resultado
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
