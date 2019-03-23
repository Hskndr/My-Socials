
package com.educacionit.mysocials.services;

import com.educacionit.mysocials.beans.User;


public interface IAuth {

    User login (String userName, String password);
}