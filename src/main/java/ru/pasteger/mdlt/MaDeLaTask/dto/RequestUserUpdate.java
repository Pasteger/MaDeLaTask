package ru.pasteger.mdlt.MaDeLaTask.dto;

import ru.pasteger.mdlt.MaDeLaTask.entity.CountryEntity;
import ru.pasteger.mdlt.MaDeLaTask.entity.DocEntity;
import ru.pasteger.mdlt.MaDeLaTask.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;

public class RequestUserUpdate {
    private Long id;
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

    public RequestUserUpdate() {}

    public List<Object> toEntity(UserEntity userInspector, DocEntity docInspector, CountryEntity countryInspector){
        UserEntity userEntity = new UserEntity();
        DocEntity docEntity = new DocEntity();
        CountryEntity countryEntity = new CountryEntity();

        userEntity.setId(id);
        userEntity.setDocCode(docCode);
        userEntity.setCitizenshipCode(citizenshipCode);
        docEntity.setCode(docCode);
        countryEntity.setCode(citizenshipCode);
        userEntity.setLogin(userInspector.getLogin());
        userEntity.setPassword(userInspector.getPassword());

        if(firstName.equals(""))
            userEntity.setFirstName(userInspector.getFirstName());
        else userEntity.setFirstName(firstName);
        if(secondName.equals(""))
            userEntity.setLastName(userInspector.getLastName());
        else userEntity.setLastName(secondName);
        if(middleName.equals(""))
            userEntity.setMiddleName(userInspector.getMiddleName());
        else userEntity.setMiddleName(middleName);
        if(position.equals(""))
            userEntity.setPosition(userInspector.getPosition());
        else userEntity.setPosition(position);
        if(phone.equals(""))
            userEntity.setPhone(userInspector.getPhone());
        else userEntity.setPhone(phone);
        if(docName.equals(""))
            docEntity.setName(docInspector.getName());
        else docEntity.setName(docName);
        if(docNumber.equals(""))
            userEntity.setDocNumber(userInspector.getDocNumber());
        else userEntity.setDocNumber(docNumber);
        if(docDate.equals(""))
            userEntity.setDocDate(userInspector.getDocDate());
        else userEntity.setDocDate(docDate);
        if(citizenshipName.equals(""))
            countryEntity.setName(countryInspector.getName());
        else countryEntity.setName(citizenshipName);

        userEntity.setIdentified(isIdentified);

        List<Object> list = new ArrayList<>();
        list.add(userEntity);
        list.add(docEntity);
        list.add(countryEntity);
        return list;
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
