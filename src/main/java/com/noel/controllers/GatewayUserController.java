package com.noel.controllers;

import com.noel.model.User;
import com.noel.proxy.UserProxy;
import com.noel.util.UserContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
@AllArgsConstructor
public class GatewayUserController {
    private final UserProxy userProxy;
    private final ObjectFactory<UserContext> context;
    @PostMapping
    public User create (@RequestBody User user) {
        return userProxy.create(user);
    }

    @GetMapping
    public User[] getAll() {
        context.getObject().assertAdmin();
        return userProxy.getAllUsers();
    }

    @GetMapping("{userId}")
    public User getUser(@PathVariable String userId) {
        context.getObject().assertAdmin();
        return userProxy.getUser(userId);
    }
}
