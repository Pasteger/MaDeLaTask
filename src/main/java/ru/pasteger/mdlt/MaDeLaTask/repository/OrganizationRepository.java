package ru.pasteger.mdlt.MaDeLaTask.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pasteger.mdlt.MaDeLaTask.entity.OrganizationEntity;

public interface OrganizationRepository extends CrudRepository<OrganizationEntity, Long> {
    OrganizationEntity findByFullName(String fullName);


}
