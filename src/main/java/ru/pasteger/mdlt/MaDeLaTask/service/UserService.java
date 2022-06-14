package ru.pasteger.mdlt.MaDeLaTask.service;

import org.springframework.stereotype.Service;
import ru.pasteger.mdlt.MaDeLaTask.dto.*;
import ru.pasteger.mdlt.MaDeLaTask.entity.CountryEntity;
import ru.pasteger.mdlt.MaDeLaTask.entity.DocEntity;
import ru.pasteger.mdlt.MaDeLaTask.entity.UserEntity;
import ru.pasteger.mdlt.MaDeLaTask.repository.CountryRepository;
import ru.pasteger.mdlt.MaDeLaTask.repository.DocRepository;
import ru.pasteger.mdlt.MaDeLaTask.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final DocRepository docRepository;
    private final CountryRepository countryRepository;
    public UserService(UserRepository userRepository, DocRepository docRepository, CountryRepository countryRepository) {
        this.userRepository = userRepository;
        this.docRepository = docRepository;
        this.countryRepository = countryRepository;
    }

    public void saveUser(RequestUserSave user) throws Exception {
        if (user.checkNull()) {
            throw new Exception("Not all fields are filled in");
        }
        userRepository.save(user.toEntity());
        docRepository.save(user.getDocEntity());
        countryRepository.save(user.getCountryEntity());
    }

    public void updateUser(RequestUserUpdate user) throws Exception {
        Optional<UserEntity> optionalUser = userRepository.findById(user.getId());
        Optional<DocEntity> optionalDoc = docRepository.findById(user.getDocCode());
        Optional<CountryEntity> optionalCountry = countryRepository.findById(user.getCitizenshipCode());
        if (optionalUser.isEmpty()){
            throw new Exception("User not exist");
        }
        UserEntity userEntity = optionalUser.get();
        DocEntity docEntity = optionalDoc.orElseGet(DocEntity::new);
        CountryEntity countryEntity = optionalCountry.orElseGet(CountryEntity::new);

        List<Object> saved = user.toEntity(userEntity, docEntity, countryEntity);
        userRepository.save((UserEntity) saved.get(0));
        docRepository.save((DocEntity) saved.get(1));
        countryRepository.save((CountryEntity) saved.get(2));
    }

    public List<ResponseUserForList> getUsersList(RequestUsersListFilter filter) throws Exception {
        if(filter.getOfficeId() == null){
            throw new Exception("Required parameter is not filled in");
        }
        List<UserEntity> entityList = userRepository.findAllByOfficeId(filter.getOfficeId());

        filtering(entityList, filter);

        List<ResponseUserForList> responseList = new ArrayList<>();
        for (UserEntity entity : entityList){
            responseList.add(ResponseUserForList.toResponseUserForList(entity));
        }
        return responseList;
    }

    public ResponseUser getUser(Long id) throws Exception {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) throw new Exception("User not exist");
        UserEntity user = userOptional.get();
        DocEntity doc;
        CountryEntity country;
        try {
            Optional<DocEntity> optionalDoc = docRepository.findById(user.getDocCode());
            doc = optionalDoc.orElseGet(DocEntity::new);
        }
        catch (Exception exception){doc = new DocEntity();}
        try {
            Optional<CountryEntity> optionalCountry = countryRepository.findById(user.getCitizenshipCode());
            country = optionalCountry.orElseGet(CountryEntity::new);
        }
        catch (Exception exception){country = new CountryEntity();}

        return ResponseUser.toResponseUser(user, doc, country);
    }

    private void filtering(List<UserEntity> entityList, RequestUsersListFilter filter){
        if(!filter.getFirstName().equals("")){
            entityList.removeIf(entity -> !Objects.equals(entity.getFirstName(), filter.getFirstName()));
        }
        if(!filter.getLastName().equals("")){
            entityList.removeIf(entity -> !Objects.equals(entity.getLastName(), filter.getLastName()));
        }
        if(!filter.getMiddleName().equals("")){
            entityList.removeIf(entity -> !Objects.equals(entity.getMiddleName(), filter.getMiddleName()));
        }
        if(!filter.getPosition().equals("")){
            entityList.removeIf(entity -> !Objects.equals(entity.getPosition(), filter.getPosition()));
        }
        if(filter.getDocCode() != null){
            entityList.removeIf(entity -> !Objects.equals(entity.getDocCode(), filter.getDocCode()));
        }
        if(filter.getCitizenshipCode() != null){
            entityList.removeIf(entity -> !Objects.equals(entity.getCitizenshipCode(), filter.getCitizenshipCode()));
        }
    }
}
