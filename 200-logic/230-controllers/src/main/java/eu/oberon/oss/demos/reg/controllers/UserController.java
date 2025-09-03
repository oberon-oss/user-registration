package eu.oberon.oss.demos.reg.controllers;

import eu.oberon.oss.demos.reg.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reg.repos.UserRepository;

import java.util.UUID;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable UUID id) {
        return userRepository.findById(id).orElse(null);
    }
}
