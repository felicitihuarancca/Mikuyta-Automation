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
    int number = random.nextInt(10000) + 1;

    public User() {
        this.fullname = "TestUsername TestSurname";
        this.email = "test-email"+number+"@gmail.com";
        this.phone = "91373733";
        this.identityNumber = "12345678";
        this.username = "tes-username-"+number;
        this.password = "testPassword";
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
