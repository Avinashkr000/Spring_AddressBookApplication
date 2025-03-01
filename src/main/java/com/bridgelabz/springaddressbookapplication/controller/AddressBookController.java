package com.bridgelabz.springaddressbookapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final Map<Long, String> addressBook = new HashMap<>();
    private long idCounter = 1;

    @PostMapping("/add")
    public ResponseEntity<String> addEntry(@RequestParam String name) {
        addressBook.put(idCounter++, name);
        return ResponseEntity.ok("Entry Added!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEntry(@PathVariable Long id) {
        return addressBook.containsKey(id) ? ResponseEntity.ok(addressBook.get(id))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable Long id, @RequestParam String name) {
        if (addressBook.containsKey(id)) {
            addressBook.put(id, name);
            return ResponseEntity.ok("Entry Updated!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        return addressBook.remove(id) != null ? ResponseEntity.ok("Entry Deleted!")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
    }
}