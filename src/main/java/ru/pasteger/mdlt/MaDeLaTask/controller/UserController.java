package ru.pasteger.mdlt.MaDeLaTask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pasteger.mdlt.MaDeLaTask.repository.UserRepository;

@Controller
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {this.userRepository = userRepository;}


}
