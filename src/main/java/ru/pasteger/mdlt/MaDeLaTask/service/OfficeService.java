package ru.pasteger.mdlt.MaDeLaTask.service;

import org.springframework.stereotype.Service;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestOfficeSave;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestOfficeUpdate;
import ru.pasteger.mdlt.MaDeLaTask.entity.OfficeEntity;
import ru.pasteger.mdlt.MaDeLaTask.exception.NotAllFieldsAreFilledInException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OfficeAlreadyExistException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OfficeNotExistException;
import ru.pasteger.mdlt.MaDeLaTask.repository.OfficeRepository;
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
}
