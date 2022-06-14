package ru.pasteger.mdlt.MaDeLaTask.dto;

import ru.pasteger.mdlt.MaDeLaTask.entity.OfficeEntity;

public class ResponseOffice {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Boolean isActive;

    public ResponseOffice() {}

    public static ResponseOffice toResponseOffice(OfficeEntity entity){
        ResponseOffice response = new ResponseOffice();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setAddress(entity.getAddress());
        response.setPhone(entity.getPhone());
        response.setIsActive(entity.getIsActive());
        return response;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
