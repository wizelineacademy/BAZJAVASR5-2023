package com.wizeline.reactive.a;

public class EjemploProgramacionReactiva {

    public static void main(String[] args) {
        Observable observable = new Observable();
        Observer observer = new EventLogger();

        Observer observer2 = new EventLogger();

        observable.addObserver(observer);
        observable.addObserver(observer2);

        observable.notifyObservers("Evento 1");
        observable.notifyObservers("Evento 2");

        observable.removeObserver(observer);

        observable.notifyObservers("Evento 3");
    }
}
