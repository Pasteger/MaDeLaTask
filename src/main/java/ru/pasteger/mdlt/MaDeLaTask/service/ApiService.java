package ru.pasteger.mdlt.MaDeLaTask.service;

import org.springframework.stereotype.Service;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestOrganizationSave;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserLogin;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserRegister;
import ru.pasteger.mdlt.MaDeLaTask.exception.*;
import ru.pasteger.mdlt.MaDeLaTask.repository.OrganizationRepository;
import ru.pasteger.mdlt.MaDeLaTask.repository.UserRepository;

@Service
public class ApiService {
    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;

    public ApiService(UserRepository userRepository, OrganizationRepository organizationRepository) {
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
    }

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

    public void saveOrganization(RequestOrganizationSave organization)
            throws NotAllFieldsAreFilledInException, OrganizationAlreadyExistException {
        if (organization.getName() == null || organization.getFullName() == null ||
            organization.getInn() == null || organization.getKpp() == null ||
            organization.getAddress() == null || organization.getPhone() == null)
        {
            throw new NotAllFieldsAreFilledInException("Not all fields are filled in");
        }
        if (organizationRepository.findByFullName(organization.getFullName()) != null){
            throw new OrganizationAlreadyExistException("Organization already exist");
        }
        organizationRepository.save(organization.toEntity());
    }
}
