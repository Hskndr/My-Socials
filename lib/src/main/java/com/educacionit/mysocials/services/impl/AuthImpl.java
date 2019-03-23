
package com.educacionit.mysocials.services.impl;


import com.educacionit.mysocials.beans.User;
import com.educacionit.mysocials.services.IAuth;
import com.educacionit.mysocials.services.SecutiryException;

public class AuthImpl implements IAuth {


    @Override
    public User login(String userName, String password) {

        if (userName.equals("homer") && password.equals ("simpson")) {

            return new User ("homer", "hsimpson@gmail.com");

        } else {

            throw new SecutiryException ("User not found.");
        }
    }
}
