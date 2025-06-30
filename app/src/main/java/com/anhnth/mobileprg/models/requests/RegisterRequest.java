package com.anhnth.mobileprg.models.requests;

public class RegisterRequest {
    public String name;
    public String email;
    public String password;
    public String confirmed_password;
    public String date_of_birth;

    public RegisterRequest(String name, String email, String password, String confirmed_password, String dob) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmed_password = confirmed_password;
        this.date_of_birth = dob;
    }
}
