package ru.pasteger.mdlt.MaDeLaTask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.pasteger.mdlt.MaDeLaTask.dto.*;
import ru.pasteger.mdlt.MaDeLaTask.service.UserService;
import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody RequestUserSave user){
        try {
            userService.saveUser(user);
            return ResponseEntity.ok().body("success");
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody RequestUserUpdate user){
        try {
            userService.updateUser(user);
            return ResponseEntity.ok().body("success");
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping("/list")
    public ResponseEntity<?> getUsersList(@RequestBody RequestUsersListFilter filter){
        try {
            List<ResponseUserForList> users = userService.getUsersList(filter);
            return ResponseEntity.ok().body(users);
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id){
        try {
            ResponseUser user = userService.getUser(id);
            return ResponseEntity.ok().body(user);
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
