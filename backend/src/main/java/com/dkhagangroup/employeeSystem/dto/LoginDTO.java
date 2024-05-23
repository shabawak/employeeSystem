package com.dkhagangroup.employeeSystem.dto;

public class LoginDTO {
    private String username;
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String email, String password) {
        this.username = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "email='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
