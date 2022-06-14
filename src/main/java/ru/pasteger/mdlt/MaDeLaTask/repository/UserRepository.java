package ru.pasteger.mdlt.MaDeLaTask.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.pasteger.mdlt.MaDeLaTask.entity.UserEntity;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByLogin(String login);

    UserEntity findByLoginAndPassword(String login, String password);

    List<UserEntity> findAllByOfficeId(Long officeId);

    UserEntity findByActivationCode(String code);
}
