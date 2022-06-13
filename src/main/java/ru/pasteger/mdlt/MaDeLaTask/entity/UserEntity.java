package ru.pasteger.mdlt.MaDeLaTask.entity;

import javax.persistence.*;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long officeId;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private String position;
    private String phone;
    private Long docCode;
    private String docNumber;
    private String docDate;
    private Long citizenshipCode;
    private Boolean isIdentified;

    public UserEntity() {}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Long getOfficeId() {return officeId;}
    public void setOfficeId(Long officeId) {this.officeId = officeId;}
    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getMiddleName() {return middleName;}
    public void setMiddleName(String middleName) {this.middleName = middleName;}
    public String getPosition() {return position;}
    public void setPosition(String position) {this.position = position;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public Long getDocCode() {return docCode;}
    public void setDocCode(Long docCode) {this.docCode = docCode;}
    public String getDocNumber() {return docNumber;}
    public void setDocNumber(String docNumber) {this.docNumber = docNumber;}
    public String getDocDate() {return docDate;}
    public void setDocDate(String docDate) {this.docDate = docDate;}
    public Long getCitizenshipCode() {return citizenshipCode;}
    public void setCitizenshipCode(Long citizenshipCode) {this.citizenshipCode = citizenshipCode;}
    public Boolean getIdentified() {return isIdentified;}
    public void setIdentified(Boolean identified) {isIdentified = identified;}
}
