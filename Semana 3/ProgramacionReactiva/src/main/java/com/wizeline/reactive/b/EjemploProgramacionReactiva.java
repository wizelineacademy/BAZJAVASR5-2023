package com.wizeline.reactive.b;

public class EjemploProgramacionReactiva {

    public static void main(String[] args) {
        EventPublisher publisher = new EventPublisher();
        EventLogger logger = new EventLogger();

        publisher.subscribe(logger);

        publisher.publishEvent("Evento 1");
        publisher.publishEvent("Evento 2");

        publisher.complete();

        publisher.publishEvent("Evento 3");
    }
}
