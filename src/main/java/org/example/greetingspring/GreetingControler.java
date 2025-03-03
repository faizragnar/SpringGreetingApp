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

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/update/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting greeting) {
        return greetingService.updateGreeting(id, greeting);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return "Greeting deleted successfully!";
    }
}
