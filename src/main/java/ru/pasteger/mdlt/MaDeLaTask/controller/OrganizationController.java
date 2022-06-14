package ru.pasteger.mdlt.MaDeLaTask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pasteger.mdlt.MaDeLaTask.dto.*;
import ru.pasteger.mdlt.MaDeLaTask.service.OrganizationService;
import java.util.List;

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
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateOrganization(@RequestBody RequestOrganizationUpdate organization){
        try {
            organizationService.updateOrganization(organization);
            return ResponseEntity.ok().body("success");
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping("/list")
    public ResponseEntity<?> getOrganizationsList(@RequestBody RequestOrganizationsListFilter filter){
        try {
            List<ResponseOrganizationForList> organizations = organizationService.getOrganizationsList(filter);
            return ResponseEntity.ok().body(organizations);
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrganization(@PathVariable("id") Long id){
        try {
            ResponseOrganization organization = organizationService.getOrganization(id);
            return ResponseEntity.ok().body(organization);
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
