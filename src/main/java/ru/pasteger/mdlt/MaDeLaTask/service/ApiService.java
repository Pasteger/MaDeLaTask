package ru.pasteger.mdlt.MaDeLaTask.service;

import org.springframework.stereotype.Service;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserLogin;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserRegister;
import ru.pasteger.mdlt.MaDeLaTask.entity.CountryEntity;
import ru.pasteger.mdlt.MaDeLaTask.entity.DocEntity;
import ru.pasteger.mdlt.MaDeLaTask.entity.UserEntity;
import ru.pasteger.mdlt.MaDeLaTask.repository.CountryRepository;
import ru.pasteger.mdlt.MaDeLaTask.repository.DocRepository;
import ru.pasteger.mdlt.MaDeLaTask.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {
    private final UserRepository userRepository;
    private final DocRepository docRepository;
    private final CountryRepository countryRepository;

    public ApiService(UserRepository userRepository, DocRepository docRepository, CountryRepository countryRepository) {
        this.userRepository = userRepository;
        this.docRepository = docRepository;
        this.countryRepository = countryRepository;
    }

    public void registration(RequestUserRegister user) throws Exception {
        if(user.getLogin() == null || user.getPassword() == null || user.getName() == null){
            throw new Exception("Incorrect request body");
        }
        if(userRepository.findByLogin(user.getLogin()) != null){
            throw new Exception("A user with this login already exists");
        }
        userRepository.save(user.toEntity());
    }

    public void authorization(RequestUserLogin user) throws Exception {
        if(userRepository.findByLogin(user.getLogin()) == null){
            throw new Exception("Incorrect login");
        }
        if(userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword()) == null){
            throw new Exception("Incorrect password");
        }
    }

    public void useActivationCode(String code){
        UserEntity user = userRepository.findByActivationCode(code);
        try {
            user.setIdentified(true);
            user.setActivationCode(null);
            userRepository.save(user);
        }
        catch (Exception ignored){}
    }

    public List<DocEntity> getDocs() throws Exception {
        Iterable<DocEntity> docEntityIterable = docRepository.findAll();
        List<DocEntity> docEntityList = new ArrayList<>();
        docEntityIterable.forEach(docEntityList::add);
        if(docEntityList.isEmpty()) throw new Exception("Database is empty");
        return docEntityList;
    }

    public List<CountryEntity> getCountries() throws Exception {
        Iterable<CountryEntity> docEntityIterable = countryRepository.findAll();
        List<CountryEntity> countryEntityList = new ArrayList<>();
        docEntityIterable.forEach(countryEntityList::add);
        if(countryEntityList.isEmpty()) throw new Exception("Database is empty");
        return countryEntityList;
    }
}
