package ru.pasteger.mdlt.MaDeLaTask.dto;

import ru.pasteger.mdlt.MaDeLaTask.entity.OrganizationEntity;

public class ResponseOrganizationForList {
    private Long id;
    private String name;
    private Boolean isActive;

    public ResponseOrganizationForList() {}

    public static ResponseOrganizationForList toResponseOrganizationForList(OrganizationEntity entity){
        ResponseOrganizationForList responseOrganizationForList = new ResponseOrganizationForList();
        responseOrganizationForList.setId(entity.getId());
        responseOrganizationForList.setName(entity.getName());
        responseOrganizationForList.setActive(entity.getActive());
        return responseOrganizationForList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
