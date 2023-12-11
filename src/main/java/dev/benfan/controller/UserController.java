package dev.benfan.controller;

import dev.benfan.models.AppUser;
import dev.benfan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody AppUser user){
        userRepository.insert(user);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAllUsers(){
        var users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<AppUser> getUser(@PathVariable String id){
        var user = userRepository.findById(id);
        return user != null
                ? ResponseEntity.ok(user)
                : ResponseEntity.notFound().build();
    }

}
