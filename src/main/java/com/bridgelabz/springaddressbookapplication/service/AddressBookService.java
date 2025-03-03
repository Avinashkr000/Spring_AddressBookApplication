package com.bridgelabz.springaddressbookapplication.service;

import com.bridgelabz.springaddressbookapplication.dto.AddressBookDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    private final List<AddressBookDTO> addressBookList = new ArrayList<>();
    private Long idCounter = 1L;

    public AddressBookDTO addEntry(String name) {
        AddressBookDTO newEntry = new AddressBookDTO(idCounter++, name);
        addressBookList.add(newEntry);
        return newEntry;
    }

    public List<AddressBookDTO> getAllEntries() {
        return addressBookList;
    }

    public AddressBookDTO getEntryById(Long id) {
        return addressBookList.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public AddressBookDTO updateEntry(Long id, String name) {
        Optional<AddressBookDTO> optionalEntry = addressBookList.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst();

        if (optionalEntry.isPresent()) {
            AddressBookDTO entry = optionalEntry.get();
            entry.setName(name);
            return entry;
        }
        return null;
    }

    public boolean deleteEntry(Long id) {
        return addressBookList.removeIf(entry -> entry.getId().equals(id));
    }
}
