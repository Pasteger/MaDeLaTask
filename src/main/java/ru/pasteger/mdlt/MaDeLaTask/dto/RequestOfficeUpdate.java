package ru.pasteger.mdlt.MaDeLaTask.dto;

import ru.pasteger.mdlt.MaDeLaTask.entity.OfficeEntity;

public class RequestOfficeUpdate {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Boolean isActive;

    public RequestOfficeUpdate() {}

    public OfficeEntity toEntity(OfficeEntity inspector){
        OfficeEntity entity = new OfficeEntity();
        entity.setId(id);
        if(name.equals(""))
            entity.setName(inspector.getName());
        else entity.setName(name);
        if(address.equals(""))
            entity.setAddress(inspector.getAddress());
        else entity.setAddress(address);
        if(phone.equals(""))
            entity.setPhone(inspector.getPhone());
        else entity.setPhone(phone);
        entity.setIsActive(isActive);
        return entity;
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
