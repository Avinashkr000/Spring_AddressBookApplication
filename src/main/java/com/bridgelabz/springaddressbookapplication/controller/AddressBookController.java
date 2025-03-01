package com.bridgelabz.springaddressbookapplication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeMessage() {
        return ResponseEntity.ok("Welcome to Address Book App!");
    }
}