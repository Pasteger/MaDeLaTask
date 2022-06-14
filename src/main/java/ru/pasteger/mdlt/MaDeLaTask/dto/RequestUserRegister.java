package ru.pasteger.mdlt.MaDeLaTask.dto;

import ru.pasteger.mdlt.MaDeLaTask.entity.UserEntity;
import java.util.Random;

public class RequestUserRegister {
    private String login;
    private String password;
    private String name;

    public RequestUserRegister() {}

    public UserEntity toEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(login);
        userEntity.setPassword(password);
        userEntity.setFirstName(name);
        userEntity.setIdentified(false);

        userEntity.setActivationCode(generateActivationCode());

        userEntity.setOfficeId(0L);
        return userEntity;
    }

    private String generateActivationCode(){
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 10; i++){
            switch (random.nextInt(4)) {
                case 0:
                    code.append(Character.toChars(57 - random.nextInt(10)));
                    break;
                case 1:
                    code.append(Character.toChars(90 - random.nextInt(26)));
                    break;
                case 2:
                    code.append(Character.toChars(122 - random.nextInt(26)));
                    break;
                case 3:
                    code.append(Character.toChars(38 - random.nextInt(4)));
                    break;
            }
        }
        return code.toString();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
