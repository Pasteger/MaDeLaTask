package ru.pasteger.mdlt.MaDeLaTask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserLogin;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserRegister;
import ru.pasteger.mdlt.MaDeLaTask.exception.IncorrectLoginException;
import ru.pasteger.mdlt.MaDeLaTask.exception.IncorrectPasswordException;
import ru.pasteger.mdlt.MaDeLaTask.exception.IncorrectRequestBodyException;
import ru.pasteger.mdlt.MaDeLaTask.exception.UserAlreadyExistException;
import ru.pasteger.mdlt.MaDeLaTask.service.ApiService;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {this.apiService = apiService;}

    @PostMapping("/register")
    public ResponseEntity<?> registration(@RequestBody RequestUserRegister requestUserRegister){
        try {
            apiService.registration(requestUserRegister);
            return ResponseEntity.ok().body("success");
        }
        catch (UserAlreadyExistException | IncorrectRequestBodyException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Couldn't add a user to the database");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestUserLogin requestUserLogin){
        try {
            apiService.authorization(requestUserLogin);
            return ResponseEntity.ok().body("success");
        }
        catch (IncorrectLoginException | IncorrectPasswordException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body("Unknown exception");
        }
    }
}
