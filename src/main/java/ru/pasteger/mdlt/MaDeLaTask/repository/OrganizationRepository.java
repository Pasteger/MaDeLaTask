package ru.pasteger.mdlt.MaDeLaTask.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pasteger.mdlt.MaDeLaTask.entity.OrganizationEntity;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<OrganizationEntity, Long> {
    OrganizationEntity findByFullName(String fullName);
    List<OrganizationEntity> findAllByName(String name);
}
