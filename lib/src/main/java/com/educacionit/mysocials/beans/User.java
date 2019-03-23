
package com.educacionit.mysocials.beans;


import java.io.Serializable;


public class User implements Serializable {


    private String userName;

    private String email;

    private String password;


    public User() {
    }

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}