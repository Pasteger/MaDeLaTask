package ru.pasteger.mdlt.MaDeLaTask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.pasteger.mdlt.MaDeLaTask.dto.*;
import ru.pasteger.mdlt.MaDeLaTask.exception.NotAllFieldsAreFilledInException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OfficeAlreadyExistException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OfficeNotExistException;
import ru.pasteger.mdlt.MaDeLaTask.exception.RequiredParameterIsNotFilledInException;
import ru.pasteger.mdlt.MaDeLaTask.service.OfficeService;
import java.util.List;

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

    @PostMapping("/list/{orgId}")
    public ResponseEntity<?> getOfficeList(@PathVariable("orgId") Long orgId, @RequestBody RequestOfficeListFilter filter){
        try {
            List<ResponseOfficeForList> organizations = officeService.getOfficeList(orgId, filter);
            return ResponseEntity.ok().body(organizations);
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOffice(@PathVariable("id") Long id){
        try {
            ResponseOffice office = officeService.getOffice(id);
            return ResponseEntity.ok().body(office);
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
