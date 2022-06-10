package ru.pasteger.mdlt.MaDeLaTask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pasteger.mdlt.MaDeLaTask.repository.OfficeRepository;

@Controller
@RequestMapping("/api/office")
public class OfficeController {
    private final OfficeRepository officeRepository;

    public OfficeController(OfficeRepository officeRepository) {this.officeRepository = officeRepository;}


}
