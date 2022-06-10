package ru.pasteger.mdlt.MaDeLaTask.service;

import org.springframework.stereotype.Service;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestOrganizationSave;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestOrganizationUpdate;
import ru.pasteger.mdlt.MaDeLaTask.entity.OrganizationEntity;
import ru.pasteger.mdlt.MaDeLaTask.exception.NotAllFieldsAreFilledInException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OrganizationAlreadyExistException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OrganizationNotExistException;
import ru.pasteger.mdlt.MaDeLaTask.repository.OrganizationRepository;

import java.util.Optional;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {this.organizationRepository = organizationRepository;}

    public void saveOrganization(RequestOrganizationSave organization)
            throws NotAllFieldsAreFilledInException, OrganizationAlreadyExistException {
        if (organization.checkNull()) {
            throw new NotAllFieldsAreFilledInException("Not all fields are filled in");
        }
        if (organizationRepository.findByFullName(organization.getFullName()) != null){
            throw new OrganizationAlreadyExistException("Organization already exist");
        }
        organizationRepository.save(organization.toEntity());
    }

    public void updateOrganization(RequestOrganizationUpdate organization)
            throws NotAllFieldsAreFilledInException, OrganizationNotExistException {
        Optional<OrganizationEntity> optionalOrganization = organizationRepository.findById(organization.getId());
        if (optionalOrganization.isEmpty()){
            throw new OrganizationNotExistException("Organization not exist");
        }
        organizationRepository.save(organization.toEntity(optionalOrganization.get()));
    }
}
