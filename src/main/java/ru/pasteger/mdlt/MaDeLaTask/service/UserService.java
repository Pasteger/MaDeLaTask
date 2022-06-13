package ru.pasteger.mdlt.MaDeLaTask.service;

import org.springframework.stereotype.Service;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserSave;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestUserUpdate;
import ru.pasteger.mdlt.MaDeLaTask.entity.CountryEntity;
import ru.pasteger.mdlt.MaDeLaTask.entity.DocEntity;
import ru.pasteger.mdlt.MaDeLaTask.entity.UserEntity;
import ru.pasteger.mdlt.MaDeLaTask.exception.NotAllFieldsAreFilledInException;
import ru.pasteger.mdlt.MaDeLaTask.exception.UserNotExistException;
import ru.pasteger.mdlt.MaDeLaTask.repository.CountryRepository;
import ru.pasteger.mdlt.MaDeLaTask.repository.DocRepository;
import ru.pasteger.mdlt.MaDeLaTask.repository.UserRepository;
import java.util.List;
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

    public void saveUser(RequestUserSave user)
            throws NotAllFieldsAreFilledInException {
        if (user.checkNull()) {
            throw new NotAllFieldsAreFilledInException("Not all fields are filled in");
        }
        userRepository.save(user.toEntity());
        docRepository.save(user.getDocEntity());
        countryRepository.save(user.getCountryEntity());
    }

    public void updateUser(RequestUserUpdate user)
            throws NotAllFieldsAreFilledInException, UserNotExistException {
        Optional<UserEntity> optionalUser = userRepository.findById(user.getId());
        Optional<DocEntity> optionalDoc = docRepository.findById(user.getDocCode());
        Optional<CountryEntity> optionalCountry = countryRepository.findById(user.getCitizenshipCode());
        if (optionalUser.isEmpty()){
            throw new UserNotExistException("User not exist");
        }
        UserEntity userEntity = optionalUser.get();
        DocEntity docEntity = optionalDoc.orElseGet(DocEntity::new);
        CountryEntity countryEntity = optionalCountry.orElseGet(CountryEntity::new);

        List<Object> saved = user.toEntity(userEntity, docEntity, countryEntity);
        userRepository.save((UserEntity) saved.get(0));
        docRepository.save((DocEntity) saved.get(1));
        countryRepository.save((CountryEntity) saved.get(2));
    }
}
