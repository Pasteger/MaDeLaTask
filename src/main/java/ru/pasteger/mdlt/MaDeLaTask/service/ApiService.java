package ru.pasteger.mdlt.MaDeLaTask.service;

import org.springframework.stereotype.Service;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserLogin;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserRegister;
import ru.pasteger.mdlt.MaDeLaTask.exception.IncorrectLoginException;
import ru.pasteger.mdlt.MaDeLaTask.exception.IncorrectPasswordException;
import ru.pasteger.mdlt.MaDeLaTask.exception.IncorrectRequestBodyException;
import ru.pasteger.mdlt.MaDeLaTask.exception.UserAlreadyExistException;
import ru.pasteger.mdlt.MaDeLaTask.repository.UserRepository;

@Service
public class ApiService {
    UserRepository userRepository;

    public ApiService(UserRepository userRepository) {this.userRepository = userRepository;}

    public void registration(RequestUserRegister user) throws UserAlreadyExistException, IncorrectRequestBodyException {
        if(user.getLogin() == null || user.getPassword() == null || user.getName() == null){
            throw new IncorrectRequestBodyException("Incorrect request body");
        }
        if(userRepository.findByLogin(user.getLogin()) != null){
            throw new UserAlreadyExistException("A user with this login already exists");
        }
        userRepository.save(user.toEntity());
    }

    public void authorization(RequestUserLogin user) throws IncorrectPasswordException, IncorrectLoginException {
        if(userRepository.findByLogin(user.getLogin()) == null){
            throw new IncorrectLoginException("Incorrect login");
        }
        if(userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword()) == null){
            throw new IncorrectPasswordException("Incorrect password");
        }
    }
}
