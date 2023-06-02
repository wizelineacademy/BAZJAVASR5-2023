package com.wizeline.reactive.b;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

class EventPublisher implements Publisher<String> {
    private Subscriber<? super String> subscriber;

    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        subscriber.onSubscribe(new EventSubscription());
    }

    public void publishEvent(String event) {
        subscriber.onNext(event);
    }

    public void complete() {
        subscriber.onComplete();
    }
}

