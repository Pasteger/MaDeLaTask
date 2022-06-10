package ru.pasteger.mdlt.MaDeLaTask.dto;

import ru.pasteger.mdlt.MaDeLaTask.entity.OrganizationEntity;

public class RequestOrganizationUpdate {
    private Long id;
    private String name;
    private String fullName;
    private String inn;
    private String kpp;
    private String address;
    private String phone;
    private Boolean isActive;

    public RequestOrganizationUpdate() {}

    public OrganizationEntity toEntity(OrganizationEntity inspector){
        OrganizationEntity organizationEntity = new OrganizationEntity();
        organizationEntity.setId(id);
        if(name.equals(""))
            organizationEntity.setName(inspector.getName());
        else organizationEntity.setName(name);
        if(fullName.equals(""))
            organizationEntity.setFullName(inspector.getFullName());
        else organizationEntity.setFullName(fullName);
        if(inn.equals(""))
            organizationEntity.setInn(inspector.getInn());
        else organizationEntity.setInn(inn);
        if(kpp.equals(""))
            organizationEntity.setKpp(inspector.getKpp());
        else organizationEntity.setKpp(kpp);
        if(address.equals(""))
            organizationEntity.setAddress(inspector.getAddress());
        else organizationEntity.setAddress(address);
        if(phone.equals(""))
            organizationEntity.setPhone(inspector.getPhone());
        else organizationEntity.setPhone(phone);
        organizationEntity.setActive(isActive);

        return organizationEntity;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
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
