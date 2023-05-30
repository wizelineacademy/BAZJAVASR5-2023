package com.module3;

import java.util.ServiceLoader;

import com.wizeline.module2.interfaces.HelloInterface;

public class Module3App {
    public static void main(String[] args) {
        Iterable<HelloInterface> services = ServiceLoader.load(HelloInterface.class);
        HelloInterface service = services.iterator().next();
        service.sayHello();
    }
}