package ru.pasteger.mdlt.MaDeLaTask.dto;

import ru.pasteger.mdlt.MaDeLaTask.entity.UserEntity;

public class ResponseUserForList {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String position;

    public ResponseUserForList() {}

    public static ResponseUserForList toResponseUserForList(UserEntity entity){
        ResponseUserForList responseUserForList = new ResponseUserForList();
        responseUserForList.setId(entity.getId());
        responseUserForList.setFirstName(entity.getFirstName());
        responseUserForList.setLastName(entity.getLastName());
        responseUserForList.setMiddleName(entity.getMiddleName());
        responseUserForList.setPosition(entity.getPosition());
        return responseUserForList;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
