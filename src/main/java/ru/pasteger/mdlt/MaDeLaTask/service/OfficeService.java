package ru.pasteger.mdlt.MaDeLaTask.service;

import org.springframework.stereotype.Service;
import ru.pasteger.mdlt.MaDeLaTask.repository.OfficeRepository;

@Service
public class OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {this.officeRepository = officeRepository;}


}
