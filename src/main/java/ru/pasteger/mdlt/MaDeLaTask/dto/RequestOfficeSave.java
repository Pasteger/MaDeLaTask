package ru.pasteger.mdlt.MaDeLaTask.dto;

import ru.pasteger.mdlt.MaDeLaTask.entity.OfficeEntity;

public class RequestOfficeSave {
    private String name;
    private String address;
    private String phone;
    private Boolean isActive;

    public RequestOfficeSave() {}

    public OfficeEntity toEntity(){
        OfficeEntity entity = new OfficeEntity();
        entity.setName(name);
        entity.setAddress(address);
        entity.setPhone(phone);
        entity.setIsActive(isActive);
        return entity;
    }

    public boolean checkNull(){return (name.equals("") || address.equals("") || phone.equals(""));}

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

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
