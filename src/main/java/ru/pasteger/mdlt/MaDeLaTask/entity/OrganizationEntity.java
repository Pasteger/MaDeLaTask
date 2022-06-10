package ru.pasteger.mdlt.MaDeLaTask.entity;

import javax.persistence.*;

@Entity
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String fullName;
    private String inn;
    private String kpp;
    private String address;
    private String phone;
    private Boolean isActive;

    public OrganizationEntity() {}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}
    public String getInn() {return inn;}
    public void setInn(String inn) {this.inn = inn;}
    public String getKpp() {return kpp;}
    public void setKpp(String kpp) {this.kpp = kpp;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public Boolean getActive() {return isActive;}
    public void setActive(Boolean active) {isActive = active;}
}
