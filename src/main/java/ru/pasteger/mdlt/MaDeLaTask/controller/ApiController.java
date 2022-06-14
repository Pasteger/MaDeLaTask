package ru.pasteger.mdlt.MaDeLaTask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserLogin;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserRegister;
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
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestUserLogin requestUserLogin){
        try {
            apiService.authorization(requestUserLogin);
            return ResponseEntity.ok().body("success");
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/activation")
    public void activation(@RequestParam("code") String code){
        apiService.useActivationCode(code);
    }

    @GetMapping("/docs")
    public ResponseEntity<?> docs(){
        try {
            return ResponseEntity.ok().body(apiService.getDocs());
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/countries")
    public ResponseEntity<?> countries(){
        try {
            return ResponseEntity.ok().body(apiService.getCountries());
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
