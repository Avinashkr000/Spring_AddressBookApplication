package com.bridgelabz.springaddressbookapplication.service;

import com.bridgelabz.springaddressbookapplication.dto.AddressBookDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {
    private final List<AddressBookDTO> addressList = new ArrayList<>();

    public AddressBookDTO addEntry(String name) {
        AddressBookDTO entry = new AddressBookDTO((long) (addressList.size() + 1), name);
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
}