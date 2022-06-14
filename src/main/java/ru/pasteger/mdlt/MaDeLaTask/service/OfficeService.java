package ru.pasteger.mdlt.MaDeLaTask.service;

import org.springframework.stereotype.Service;
import ru.pasteger.mdlt.MaDeLaTask.dto.*;
import ru.pasteger.mdlt.MaDeLaTask.entity.OfficeEntity;
import ru.pasteger.mdlt.MaDeLaTask.exception.NotAllFieldsAreFilledInException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OfficeAlreadyExistException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OfficeNotExistException;
import ru.pasteger.mdlt.MaDeLaTask.exception.RequiredParameterIsNotFilledInException;
import ru.pasteger.mdlt.MaDeLaTask.repository.OfficeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {this.officeRepository = officeRepository;}

    public void saveOffice(RequestOfficeSave office)
            throws NotAllFieldsAreFilledInException, OfficeAlreadyExistException {
        if (office.checkNull()) {
            throw new NotAllFieldsAreFilledInException("Not all fields are filled in");
        }
        if (officeRepository.findByName(office.getName()) != null){
            throw new OfficeAlreadyExistException("Office already exist");
        }
        officeRepository.save(office.toEntity());
    }

    public void updateOffice(RequestOfficeUpdate office)
            throws NotAllFieldsAreFilledInException, OfficeNotExistException {
        Optional<OfficeEntity> optionalOffice = officeRepository.findById(office.getId());
        if (optionalOffice.isEmpty()){
            throw new OfficeNotExistException("Office not exist");
        }
        officeRepository.save(office.toEntity(optionalOffice.get()));
    }

    public List<ResponseOfficeForList> getOfficeList(Long orgId, RequestOfficeListFilter filter)
            throws RequiredParameterIsNotFilledInException {
        filter.setOrgId(orgId);
        if(filter.getOrgId() == null){
            throw new RequiredParameterIsNotFilledInException("Required parameter is not filled in");
        }
        List<OfficeEntity> entityList = officeRepository.findAllByOrgId(orgId);

        filtering(entityList, filter);

        List<ResponseOfficeForList> responseList = new ArrayList<>();
        for (OfficeEntity entity : entityList){
            responseList.add(ResponseOfficeForList.toResponseOfficeForList(entity));
        }
        return responseList;
    }

    public ResponseOffice getOffice(Long id) throws Exception {
        Optional<OfficeEntity> office = officeRepository.findById(id);
        if(office.isEmpty()) throw new Exception("Office not exist");
        return ResponseOffice.toResponseOffice(office.get());
    }

    private void filtering(List<OfficeEntity> entityList, RequestOfficeListFilter filter){
        if(!filter.getName().equals("")){
            entityList.removeIf(entity -> !Objects.equals(entity.getName(), filter.getName()));
        }
        if(!filter.getPhone().equals("")){
            entityList.removeIf(entity -> !Objects.equals(entity.getPhone(), filter.getPhone()));
        }
        if(filter.getIsActive() != null){
            entityList.removeIf(entity -> !Objects.equals(entity.getIsActive(), filter.getIsActive()));
        }
    }
}
