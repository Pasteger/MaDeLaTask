package ru.pasteger.mdlt.MaDeLaTask.dto;

import ru.pasteger.mdlt.MaDeLaTask.entity.UserEntity;

public class RequestUserLogin {
    private String login;
    private String password;

    public RequestUserLogin() {}

    public static RequestUserLogin toDTO(UserEntity userEntity){
        RequestUserLogin requestUserLogin = new RequestUserLogin();
        requestUserLogin.setLogin(userEntity.getLogin());
        requestUserLogin.setPassword(userEntity.getPassword());
        return requestUserLogin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
