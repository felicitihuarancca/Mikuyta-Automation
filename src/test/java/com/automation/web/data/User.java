package com.automation.web.data;

import java.util.Random;

public class User {

    private String fullname;
    private String email;
    private String phone;
    private String identityNumber;
    private String username;
    private String password;

    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();

    String generatedString = random.ints(leftLimit, rightLimit + 1)
            .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

    public User() {
        this.fullname = "TestUsername TestSurname";
        this.email = "test-email@gmail.com";
        this.phone = "91373733";
        this.identityNumber = "12345678";
        this.username = "test-username-"+generatedString;
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
