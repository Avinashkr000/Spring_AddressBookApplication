package com.bridgelabz.springaddressbookapplication.exceptionhandler;

public class AddressBookNotFoundException extends RuntimeException {
    public AddressBookNotFoundException(String message) {
        super(message);
    }
}
