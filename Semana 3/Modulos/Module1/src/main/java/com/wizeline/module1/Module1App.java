package com.wizeline.module1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Module1App {

    private static final Logger logger = LogManager.getLogger(Module1App.class);

    public void sayHello() {
        logger.info("Hello from Module1App");
    }

    public Logger getLogger () {
        return logger;
    }

    public static void main (String []args) {
        new Module1App().sayHello();
    }
}