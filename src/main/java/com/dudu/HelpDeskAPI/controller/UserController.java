package com.dudu.HelpDeskAPI.controller;

import com.dudu.HelpDeskAPI.dto.user.UserRequest;
import com.dudu.HelpDeskAPI.dto.user.UserResponse;
import com.dudu.HelpDeskAPI.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> CreateNewUser(@RequestBody UserRequest dataToCreate) {
        userService.createNewUser(dataToCreate);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(dataToCreate));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> allUsers = userService.getAllUsers();

        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserResponse userFound = userService.getUserById(id);

        return ResponseEntity.ok(userFound);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest newData) {
        UserResponse userToUpdate = userService.updateUser(id, newData);

        return ResponseEntity.ok(userToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);

        return ResponseEntity.noContent().build();
    }
}
