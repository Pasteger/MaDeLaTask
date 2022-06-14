package ru.pasteger.mdlt.MaDeLaTask.dto;

import ru.pasteger.mdlt.MaDeLaTask.entity.CountryEntity;
import ru.pasteger.mdlt.MaDeLaTask.entity.DocEntity;
import ru.pasteger.mdlt.MaDeLaTask.entity.UserEntity;

public class ResponseUser {
    private Long id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
    private String phone;
    private String docName;
    private String docNumber;
    private String docDate;
    private String citizenshipName;
    private Long citizenshipCode;
    private Boolean isIdentified;

    public ResponseUser() {}

    public static ResponseUser toResponseUser(UserEntity userEntity, DocEntity docEntity, CountryEntity countryEntity){
        ResponseUser response = new ResponseUser();
        response.setId(userEntity.getId());
        response.setFirstName(userEntity.getFirstName());
        response.setSecondName(userEntity.getLastName());
        response.setMiddleName(userEntity.getMiddleName());
        response.setPosition(userEntity.getPosition());
        response.setPhone(userEntity.getPhone());
        response.setDocName(docEntity.getName());
        response.setDocNumber(userEntity.getDocNumber());
        response.setDocDate(userEntity.getDocDate());
        response.setCitizenshipName(countryEntity.getName());
        response.setCitizenshipCode(userEntity.getCitizenshipCode());
        return response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public Long getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(Long citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }
}
