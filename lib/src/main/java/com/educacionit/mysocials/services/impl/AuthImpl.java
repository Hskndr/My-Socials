
package com.educacionit.mysocials.services.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.educacionit.mysocials.beans.User;
import com.educacionit.mysocials.services.IAuth;
import com.educacionit.mysocials.services.SecutiryException;


public class AuthImpl implements IAuth {


    private Connection conn;


    public AuthImpl (Connection conn) {

        this.conn = conn;
    }


    @Override
    public User login(String userName, String password) {

        User us = null;

        try {

            Statement st = this.conn.createStatement ();

            ResultSet rs = st.executeQuery ("select c.name, u.* from users u, country c where u.id_country = c.id_country and user_name='" + userName + "' and us_pw='" + password + "'");

            while (rs.next ()) {

                us = new User ();
                us.setUserName (rs.getString ("user_name"));
                us.setFirstName (rs.getString ("first_name"));
                us.setLastName (rs.getString ("last_name"));
                us.setEmail (rs.getString ("email"));
                us.setAddress (rs.getString ("address"));
                us.setPhone (rs.getString ("phone"));
                us.getCountry ().setId (rs.getLong ("id_country"));
                us.getCountry ().setName (rs.getString ("name"));
                us.setPassword (password);
            }

        } catch (Exception e) {

            throw new SecutiryException (e.getMessage(), e);
        }

        if (us == null) {
            throw new SecutiryException ("User not found.");
        }

        return us;
    }
}