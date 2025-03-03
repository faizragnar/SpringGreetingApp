package org.example.greetingspring;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/greet")
public class GreetingControler{

    private final GreetingService greetingService;

    public GreetingControler(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting);
    }

    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }



}
