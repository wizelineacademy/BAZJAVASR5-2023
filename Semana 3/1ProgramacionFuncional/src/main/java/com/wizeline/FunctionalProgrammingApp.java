package com.wizeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.wizeline.repository.CustomerRepository;
import com.wizeline.repository.OrderRepository;
import com.wizeline.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class FunctionalProgrammingApp implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        new SpringApplicationBuilder(FunctionalProgrammingApp.class).web(WebApplicationType.NONE).run(args);
    }

    @Override
    public void run(String... args) {
        log.info("Customers:");
        customerRepository.findAll()
                .forEach(c -> log.info(c.toString()));

        log.info("Orders:");
        orderRepository.findAll()
                .forEach(o -> log.info(o.toString()));

        log.info("Products:");
        productRepository.findAll()
                .forEach(p -> log.info(p.toString()));

        // TODO: Add logic
    }


}