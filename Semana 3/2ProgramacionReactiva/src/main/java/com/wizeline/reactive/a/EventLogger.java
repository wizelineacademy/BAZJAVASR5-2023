package com.wizeline.reactive.a;

class EventLogger implements Observer {
    @Override
    public void update(String event) {
        System.out.println("Evento registrado: " + event);
    }
}
