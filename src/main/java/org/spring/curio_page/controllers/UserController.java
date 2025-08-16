package org.spring.curio_page.controllers;


import org.spring.curio_page.model.User;
import org.spring.curio_page.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "Welcome to the Curio Page Website🙂!";
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/sign_up")
    public ResponseEntity<String> SignUp(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/login")
    public ResponseEntity<String> Login(@RequestParam String username, @RequestParam String password) {
        return userService.loginUser(username, password);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@RequestBody String username, @RequestBody String email) {
        return userService.deleteUser(username, email);
    }

}
