package org.example.initiationspring;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

record Greeting(long id, String content) { }

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public  Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        return new Greeting(
                counter.incrementAndGet(),
                "Hello, " + name + "!"
        );
    }
}