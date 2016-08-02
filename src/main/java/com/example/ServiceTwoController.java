package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RefreshScope
@RestController
public class ServiceTwoController {

    private final String message;

    public ServiceTwoController(@Value("${message}") String message) {
        this.message = message;
    }

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public @ResponseBody Map<String, String> greet() {
        return Collections.singletonMap("hello", "world");
    }

    @RequestMapping(value = "message", method = RequestMethod.GET)
    public @ResponseBody Map<String, String> message() {
        return Collections.singletonMap("message", message);
    }
}
