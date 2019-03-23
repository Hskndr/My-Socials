
package com.educacionit.mysocials.beans;


import java.io.Serializable;


public class User implements Serializable {


    private String userName;

    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String phone;

    private Country country = new Country ();

    private String password;


    public User () {

        super ();
    }

    public User (String userName, String email, String firstName,
                 String lastName, String address, String phone,
                 Country country) {

        super ();

        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.country = country;
    }


    public String getUserName () {

        return userName;
    }

    public void setUserName (String userName) {

        this.userName = userName;
    }

    public String getEmail () {

        return email;
    }

    public void setEmail (String email) {

        this.email = email;
    }

    public String getFirstName () {

        return firstName;
    }

    public void setFirstName (String firstName) {

        this.firstName = firstName;
    }

    public String getLastName () {

        return lastName;
    }

    public void setLastName (String lastName) {

        this.lastName = lastName;
    }

    public String getAddress () {

        return address;
    }

    public void setAddress (String address) {

        this.address = address;
    }

    public String getPhone () {

        return phone;
    }

    public void setPhone (String phone) {

        this.phone = phone;
    }

    public Country getCountry () {

        return country;
    }

    public void setCountry (Country country) {

        this.country = country;
    }

    public String getPassword () {

        return password;
    }

    public void setPassword (String password) {

        this.password = password;
    }
}