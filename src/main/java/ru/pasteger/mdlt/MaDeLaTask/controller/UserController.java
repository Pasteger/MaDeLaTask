package ru.pasteger.mdlt.MaDeLaTask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserSave;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserUpdate;
import ru.pasteger.mdlt.MaDeLaTask.exception.*;
import ru.pasteger.mdlt.MaDeLaTask.service.UserService;

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
        catch (NotAllFieldsAreFilledInException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Unknown exception");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody RequestUserUpdate user){
        try {
            userService.updateUser(user);
            return ResponseEntity.ok().body("success");
        }
        catch (NotAllFieldsAreFilledInException | UserNotExistException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Unknown exception");
        }
    }
}
