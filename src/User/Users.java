package User;

import java.util.Scanner;

public class Users {

    private String name;
    private String userName;
    private String age;
    private String email;
    private String password;

    private String points;
    private boolean logIn;

    public Users(String userName, String name, String age, String email, String password, String points) {
        this.name = name;
        this.userName = userName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.points = points;
    }

    public Users() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public boolean isLogIn() {
        return logIn;
    }

    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }

    public String toString() {
        return getName() + getUserName() + getAge() + getEmail() + getPassword();
    }
}
