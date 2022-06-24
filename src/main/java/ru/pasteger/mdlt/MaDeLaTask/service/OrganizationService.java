package ru.pasteger.mdlt.MaDeLaTask.service;

import org.springframework.stereotype.Service;
import ru.pasteger.mdlt.MaDeLaTask.dto.*;
import ru.pasteger.mdlt.MaDeLaTask.entity.OrganizationEntity;
import ru.pasteger.mdlt.MaDeLaTask.repository.OrganizationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {this.organizationRepository = organizationRepository;}

    public void saveOrganization(RequestOrganizationSave organization) throws Exception {
        if (organization.checkNull()) {
            throw new Exception("Not all fields are filled in");
        }
        if (organizationRepository.findByFullName(organization.getFullName()) != null){
            throw new Exception("Organization already exist");
        }
        organizationRepository.save(organization.toEntity());
    }

    public void updateOrganization(RequestOrganizationUpdate organization) throws Exception {
        Optional<OrganizationEntity> optionalOrganization = organizationRepository.findById(organization.getId());
        if (optionalOrganization.isEmpty()){
            throw new Exception("Organization not exist");
        }
        organizationRepository.save(organization.toEntity(optionalOrganization.get()));
    }

    public List<ResponseOrganizationForList> getOrganizationsList(RequestOrganizationsListFilter filter) throws Exception {
        if(filter.getName().equals("")){
            throw new Exception("Required parameter is not filled in");
        }
        List<OrganizationEntity> entityList = organizationRepository.findAllByNameLike("%" + filter.getName() + "%");

        filtering(entityList, filter);

        List<ResponseOrganizationForList> responseList = new ArrayList<>();
        for (OrganizationEntity entity : entityList){
            responseList.add(ResponseOrganizationForList.toResponseOrganizationForList(entity));
        }
        return responseList;
    }

    public ResponseOrganization getOrganization(Long id) throws Exception {
        Optional<OrganizationEntity> organization = organizationRepository.findById(id);
        if(organization.isEmpty()) throw new Exception("Organization not exist");
        return ResponseOrganization.toResponseOrganization(organization.get());
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
