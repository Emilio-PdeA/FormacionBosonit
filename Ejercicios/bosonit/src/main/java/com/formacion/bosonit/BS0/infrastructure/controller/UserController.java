package com.formacion.bosonit.BS0.infrastructure.controller;

import com.formacion.bosonit.BS0.domain.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("BS0")
public class UserController {

    /*
    * METHOD: GET
    * Test URL: localhost:8080/user/{name}
    * Response: "Hello, {name}"
    */
    private static final String template = "Hello, %s";
    @GetMapping("/user/{name}")
    public String getUser(@PathVariable String name){
        return String.format(template,name);
    }

    /*
    * METHOD: POST
    * Test URL: localhost:8080/useradd
    * BODY (JSON): {"name":$name, "city":$city, "age":$age}
    * RESPONSE: {"name":$name, "city":$city, "age":$age + 1}
    * */
    @PostMapping(path="/useradd", consumes = "application/json")
    public User postUser(@RequestBody User user) {
        User userReturn = new User(user.getName(),user.getCity(),user.getAge()+1);

        return userReturn;
    }


}
