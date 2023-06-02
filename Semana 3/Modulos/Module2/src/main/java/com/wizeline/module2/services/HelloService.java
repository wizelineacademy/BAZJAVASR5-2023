package com.wizeline.module2.services;

import com.wizeline.module2.interfaces.HelloInterface;

public class HelloService implements HelloInterface {
    @Override public void sayHello() {
        System.out.println("Hello");
    }
}
