package io.nology.uruguayspringintro.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Map all http requests to localhost:8080/greeting to this class
@RequestMapping("/greeting")//"main" end point

public class GreetingController {
    
//    GET, POST, PUT/PATCH, DELETE
    
    //GET
    //
    @GetMapping
    public String hello() {
	return "Hello world";
    }
    
    @GetMapping("/goodbye")
    public String goodbye() {
	return "Goodbye, world!";
    }
    
//    DYNAMIC ROUTE
//    If we want to see different name that we type in instead of "world"
    @GetMapping("/{name}")
    public String helloWithName(@PathVariable String name) {
	return String.format("Hello, %s!", name);
    }

}
