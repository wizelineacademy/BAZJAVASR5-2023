package com.wizeline.containers.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/k8s")
public class K8sController {

    @GetMapping("/hello")
    public ResponseEntity<String> helloK8S() {
        System.out.println("Saying Hello World!");
        return new ResponseEntity<>("Hello World!", HttpStatusCode.valueOf(200));
    }


}
