package ru.pasteger.mdlt.MaDeLaTask.service;

import org.springframework.stereotype.Service;
import ru.pasteger.mdlt.MaDeLaTask.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}
}
