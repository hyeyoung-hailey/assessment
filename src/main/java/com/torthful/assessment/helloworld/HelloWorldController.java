package com.torthful.assessment.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld() throws Exception {
        return "Hello world";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() throws Exception {
        return new HelloWorldBean("Hello World");
    }


}

