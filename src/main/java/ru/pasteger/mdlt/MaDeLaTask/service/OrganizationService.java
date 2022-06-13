package ru.pasteger.mdlt.MaDeLaTask.service;

import org.springframework.stereotype.Service;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestOrganizationSave;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestOrganizationUpdate;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestOrganizationsListFilter;
import ru.pasteger.mdlt.MaDeLaTask.dto.ResponseOrganizationForList;
import ru.pasteger.mdlt.MaDeLaTask.entity.OrganizationEntity;
import ru.pasteger.mdlt.MaDeLaTask.exception.NotAllFieldsAreFilledInException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OrganizationAlreadyExistException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OrganizationNotExistException;
import ru.pasteger.mdlt.MaDeLaTask.exception.RequiredParameterIsNotFilledInException;
import ru.pasteger.mdlt.MaDeLaTask.repository.OrganizationRepository;
import java.util.ArrayList;
import java.util.List;
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

    public List<ResponseOrganizationForList> getOrganizationsList(RequestOrganizationsListFilter filter)
            throws RequiredParameterIsNotFilledInException {
        if(filter.getName().equals("")){
            throw new RequiredParameterIsNotFilledInException("Required parameter is not filled in");
        }
        List<OrganizationEntity> entityList = organizationRepository.findAllByName(filter.getName());

        filtering(entityList, filter);

        List<ResponseOrganizationForList> responseList = new ArrayList<>();
        for (OrganizationEntity entity : entityList){
            responseList.add(ResponseOrganizationForList.toResponseOrganizationForList(entity));
        }
        return responseList;
    }

    private void filtering(List<OrganizationEntity> entityList, RequestOrganizationsListFilter filter){
        if(filter.getIsActive() != null){
            entityList.removeIf(entity -> entity.getActive() != filter.getIsActive());
        }
        if(!filter.getInn().equals("")){
            entityList.removeIf(entity -> !entity.getInn().equals(filter.getInn()));
        }
    }
}
