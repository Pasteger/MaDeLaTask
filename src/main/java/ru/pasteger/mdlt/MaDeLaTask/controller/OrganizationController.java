package ru.pasteger.mdlt.MaDeLaTask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestOrganizationSave;
import ru.pasteger.mdlt.MaDeLaTask.dto.RequestOrganizationUpdate;
import ru.pasteger.mdlt.MaDeLaTask.exception.NotAllFieldsAreFilledInException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OrganizationAlreadyExistException;
import ru.pasteger.mdlt.MaDeLaTask.exception.OrganizationNotExistException;
import ru.pasteger.mdlt.MaDeLaTask.service.OrganizationService;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {this.organizationService = organizationService;}

    @PostMapping("/save")
    public ResponseEntity<?> saveOrganization(@RequestBody RequestOrganizationSave organization){
        try {
            organizationService.saveOrganization(organization);
            return ResponseEntity.ok().body("success");
        }
        catch (NotAllFieldsAreFilledInException | OrganizationAlreadyExistException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Unknown exception");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateOrganization(@RequestBody RequestOrganizationUpdate organization){
        try {
            organizationService.updateOrganization(organization);
            return ResponseEntity.ok().body("success");
        }
        catch (NotAllFieldsAreFilledInException | OrganizationNotExistException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Unknown exception");
        }
    }
}
