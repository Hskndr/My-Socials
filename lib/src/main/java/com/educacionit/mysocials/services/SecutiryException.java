
package com.educacionit.mysocials.services;


public class SecutiryException extends RuntimeException {


    public SecutiryException () {
    }

    public SecutiryException (String message) {

        super (message);
    }

    public SecutiryException(String message, Throwable cause) {

        super(message, cause);
    }

    public SecutiryException (Throwable cause) {

        super(cause);
    }
}