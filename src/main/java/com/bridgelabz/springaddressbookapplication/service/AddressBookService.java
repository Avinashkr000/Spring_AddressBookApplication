package com.bridgelabz.springaddressbookapplication.service;

import com.bridgelabz.springaddressbookapplication.dto.AddressBookDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {
    private final List<AddressBookDTO> addressList = new ArrayList<>();
    private long idCounter = 1;

    public AddressBookDTO addEntry(String name) {
        AddressBookDTO entry = new AddressBookDTO(idCounter++, name);
        addressList.add(entry);
        return entry;
    }

    public List<AddressBookDTO> getAllEntries() {
        return addressList;
    }

    public AddressBookDTO getEntryById(Long id) {
        return addressList.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public AddressBookDTO updateEntry(Long id, String newName) {
        for (AddressBookDTO entry : addressList) {
            if (entry.getId().equals(id)) {
                addressList.remove(entry);
                AddressBookDTO updatedEntry = new AddressBookDTO(id, newName);
                addressList.add(updatedEntry);
                return updatedEntry;
            }
        }
        return null;
    }

    public boolean deleteEntry(Long id) {
        return addressList.removeIf(entry -> entry.getId().equals(id));
    }
}