package ru.pasteger.mdlt.MaDeLaTask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestOfficeSave;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestOfficeUpdate;
import ru.pasteger.mdlt.MaDeLaTask.exception.NotAllFieldsAreFilledInException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OfficeAlreadyExistException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OfficeNotExistException;
import ru.pasteger.mdlt.MaDeLaTask.service.OfficeService;

@Controller
@RequestMapping("/api/office")
public class OfficeController {
    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {this.officeService = officeService;}

    @PostMapping("/save")
    public ResponseEntity<?> saveOffice(@RequestBody RequestOfficeSave office){
        try {
            officeService.saveOffice(office);
            return ResponseEntity.ok().body("success");
        }
        catch (NotAllFieldsAreFilledInException | OfficeAlreadyExistException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Unknown exception");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateOffice(@RequestBody RequestOfficeUpdate office){
        try {
            officeService.updateOffice(office);
            return ResponseEntity.ok().body("success");
        }
        catch (NotAllFieldsAreFilledInException | OfficeNotExistException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Unknown exception");
        }
    }
}
