package ru.pasteger.mdlt.MaDeLaTask.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pasteger.mdlt.MaDeLaTask.entity.CountryEntity;

public interface CountryRepository extends CrudRepository<CountryEntity, Long> {
}
