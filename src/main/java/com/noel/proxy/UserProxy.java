package com.noel.proxy;

import com.noel.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

// This is a class that transmits all http requests from the user to user service
@Component
public class UserProxy {
    private final RestTemplate restTemplate;
    private final String url;

    public UserProxy(@Value("${url.user}") String url, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public User create(User user) {
        return null;
    }

    public List<User> getAllUsers() {
        return null;
    }

    public User getUser(String userId) {
        return null;
    }
}
