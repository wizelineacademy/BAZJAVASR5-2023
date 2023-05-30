package com.wizeline.module2;

import com.wizeline.module1.Module1App;

public class Module2App {
    public static void main(String[] args) {
        new Module1App().sayHello();

        new Module1App().getLogger().info("Uses logger");
    }
}