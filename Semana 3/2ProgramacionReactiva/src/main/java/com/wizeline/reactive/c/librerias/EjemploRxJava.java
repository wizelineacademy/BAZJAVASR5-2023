package com.wizeline.reactive.c.librerias;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class EjemploRxJava {

    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.range(1, 10)
                .map(i -> "Evento " + i)
                .subscribeOn(Schedulers.computation());

        flowable.subscribe(
                event -> System.out.println("Evento registrado: " + event),
                Throwable::printStackTrace,
                () -> System.out.println("Proceso completado")
        );

        // Esperar hasta que el procesamiento se complete
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
