package com.shiva.controller;

import com.shiva.service.UserService;
import com.shiva.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor // Constructor injection for final fields
public class UserController {
//@Autowired
private final UserService userService;
   @GetMapping("/api/users")
    public List<User> getUsers() {
         return userService.getUsers();
    }

    @GetMapping("/api/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
       return  userService.getUserById(id);
    }

     @PutMapping("/api/users/{id}")
     public ResponseEntity<User> updateUserInfo (@PathVariable Long id , @RequestBody User user){
        return  userService.updateInfoById(id, user).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
     }


    @PostMapping("/api/users")
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return  "User created successfully";
    }

}
