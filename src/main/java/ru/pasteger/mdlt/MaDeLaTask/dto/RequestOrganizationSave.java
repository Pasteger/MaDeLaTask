package ru.pasteger.mdlt.MaDeLaTask.dto;

import ru.pasteger.mdlt.MaDeLaTask.entity.OrganizationEntity;

public class RequestOrganizationSave {
    private String name;
    private String fullName;
    private String inn;
    private String kpp;
    private String address;
    private String phone;
    private Boolean isActive;

    public RequestOrganizationSave() {}

    public OrganizationEntity toEntity(){
        OrganizationEntity organizationEntity = new OrganizationEntity();
        organizationEntity.setName(name);
        organizationEntity.setFullName(fullName);
        organizationEntity.setInn(inn);
        organizationEntity.setKpp(kpp);
        organizationEntity.setAddress(address);
        organizationEntity.setPhone(phone);
        organizationEntity.setActive(isActive);

        return organizationEntity;
    }

    public Boolean checkNull(){
        return (name == null || fullName == null || inn == null || kpp == null || address == null || phone == null);
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
