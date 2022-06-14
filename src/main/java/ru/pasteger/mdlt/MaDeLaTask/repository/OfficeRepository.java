package ru.pasteger.mdlt.MaDeLaTask.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pasteger.mdlt.MaDeLaTask.entity.OfficeEntity;

import java.util.List;

public interface OfficeRepository extends CrudRepository<OfficeEntity, Long> {
    OfficeEntity findByName(String name);

    List<OfficeEntity> findAllByOrgId(Long orgId);
}
