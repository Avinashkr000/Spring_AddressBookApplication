package com.bridgelabz.springaddressbookapplication.controller;

import com.bridgelabz.springaddressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.springaddressbookapplication.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @PostMapping("/add")
    public ResponseEntity<AddressBookDTO> addEntry(@RequestParam String name) {
        return ResponseEntity.ok(service.addEntry(name));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressBookDTO>> getAllEntries() {
        return ResponseEntity.ok(service.getAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getEntryById(@PathVariable Long id) {
        AddressBookDTO entry = service.getEntryById(id);
        return (entry != null) ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookDTO> updateEntry(@PathVariable Long id, @RequestParam String name) {
        AddressBookDTO updatedEntry = service.updateEntry(id, name);
        return (updatedEntry != null) ? ResponseEntity.ok(updatedEntry) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        return service.deleteEntry(id) ? ResponseEntity.ok("Entry Deleted!") : ResponseEntity.notFound().build();
    }
}