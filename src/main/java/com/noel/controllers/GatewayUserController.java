package com.noel.controllers;

import com.noel.model.User;
import com.noel.proxy.UserProxy;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
@AllArgsConstructor
public class GatewayUserController {
    private final UserProxy userProxy;
    @PostMapping
    public User create (@RequestBody User user) {
        return userProxy.create(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userProxy.getAllUsers();
    }

    @GetMapping("{userId}")
    public User getUser(@PathVariable String userId) {
        return userProxy.getUser(userId);
    }
}
