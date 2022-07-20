package me.sathish.sathishatazure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Azure Spring Cloud!";
    }
}
