package ru.pasteger.mdlt.MaDeLaTask.dto;

import ru.pasteger.mdlt.MaDeLaTask.entity.CountryEntity;
import ru.pasteger.mdlt.MaDeLaTask.entity.DocEntity;
import ru.pasteger.mdlt.MaDeLaTask.entity.UserEntity;

public class RequestUserSave {
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
    private String phone;
    private Long docCode;
    private String docName;
    private String docNumber;
    private String docDate;
    private String citizenshipName;
    private Long citizenshipCode;
    private Boolean isIdentified;

    public RequestUserSave() {}

    public UserEntity toEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(firstName);
        userEntity.setLastName(secondName);
        userEntity.setMiddleName(middleName);
        userEntity.setPosition(position);
        userEntity.setPhone(phone);
        userEntity.setDocCode(docCode);
        userEntity.setDocNumber(docNumber);
        userEntity.setDocDate(docDate);
        userEntity.setCitizenshipCode(citizenshipCode);
        userEntity.setIdentified(isIdentified);

        userEntity.setOfficeId(0L);
        return userEntity;
    }

    public DocEntity getDocEntity(){
        DocEntity docEntity = new DocEntity();
        docEntity.setCode(docCode);
        docEntity.setName(docName);
        return docEntity;
    }

    public CountryEntity getCountryEntity(){
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCode(citizenshipCode);
        countryEntity.setName(citizenshipName);
        return countryEntity;
    }

    public boolean checkNull(){
        return (firstName.equals("") || secondName.equals("") || middleName.equals("") || position.equals("") ||
                phone.equals("") || docName.equals("") || docNumber.equals("") || docDate.equals("") ||
                citizenshipName.equals(""));
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

    public Long getDocCode() {
        return docCode;
    }

    public void setDocCode(Long docCode) {
        this.docCode = docCode;
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

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(Boolean identified) {
        isIdentified = identified;
    }
}
