package com.automation.web.data;

import java.util.Random;

public class User {

    private String fullname;
    private String email;
    private String phone;
    private String identityNumber;
    private String username;
    private String password;

    Random  random = new Random();
    int number = random.nextInt(10) + 1;

    public User() {
        this.fullname = "Feliciti Huarancca";
        this.email = "feliciti"+number+"@gmail.com";
        this.phone = "91373733";
        this.identityNumber = "12345678";
        this.username = "licity";
        this.password = "teamoperu22";
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
