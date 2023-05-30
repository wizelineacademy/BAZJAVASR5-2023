package com.wizeline.reactive.b;

import java.util.concurrent.Flow;

class EventLogger implements Flow.Subscriber<String> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(String event) {
        System.out.println("Evento registrado: " + event);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println("Error: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Proceso completado");
        // subscription.cancel();
    }
}
