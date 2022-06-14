package ru.pasteger.mdlt.MaDeLaTask.dto;

import ru.pasteger.mdlt.MaDeLaTask.entity.OfficeEntity;

public class ResponseOfficeForList {
    private Long id;
    private String name;
    private Boolean isActive;

    public ResponseOfficeForList() {}

    public static ResponseOfficeForList toResponseOfficeForList(OfficeEntity entity){
        ResponseOfficeForList responseUserForList = new ResponseOfficeForList();
        responseUserForList.setId(entity.getId());
        responseUserForList.setName(entity.getName());
        responseUserForList.setIsActive(entity.getIsActive());
        return responseUserForList;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
