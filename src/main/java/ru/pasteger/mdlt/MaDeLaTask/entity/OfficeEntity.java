package ru.pasteger.mdlt.MaDeLaTask.entity;

import javax.persistence.*;

@Entity
public class OfficeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long orgId;
    private String name;
    private String address;
    private String phone;
    private Boolean isActive;

    public OfficeEntity() {}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Long getOrgId() {return orgId;}
    public void setOrgId(Long orgId) {this.orgId = orgId;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public Boolean getIsActive() {return isActive;}
    public void setIsActive(Boolean active) {isActive = active;}
}
