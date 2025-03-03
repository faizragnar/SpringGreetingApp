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
    @GetMapping("/{name}")
    public Greeting getGreet(@PathVariable String name){
        return new Greeting("Hello, "+name+"!");
    }
    @PostMapping("/post")
    public Greeting postGreeting(@RequestBody Greeting greeting) {
        return new Greeting("Received: " + greeting.getMessage());
    }

    @PutMapping("/update/{name}")
    public Greeting putGreeting(@PathVariable String name, @RequestBody Greeting greeting) {
        return new Greeting("Updated: " + name + " -> " + greeting.getMessage());
    }

    @DeleteMapping("/remove/{name}")
    public Greeting deleteGreeting(@PathVariable String name) {
        return new Greeting("Deleted: " + name);
    }

    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting);
    }


}
