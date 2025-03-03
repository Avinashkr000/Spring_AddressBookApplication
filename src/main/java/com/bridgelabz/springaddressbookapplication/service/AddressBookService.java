package com.bridgelabz.springaddressbookapplication.service;
import com.bridgelabz.springaddressbookapplication.dto.AddressBookDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AddressBookService {
    private final List<AddressBookDTO> addressList = new ArrayList<>();
    private long idCounter = 1;

    public AddressBookDTO addEntry(String name) {
        AddressBookDTO entry = new AddressBookDTO(idCounter++, name);
        addressList.add(entry);
        log.info("Added new entry: {}", entry);
        return entry;
    }

    public List<AddressBookDTO> getAllEntries() {
        log.info("Fetching all entries");
        return addressList;
    }

    public AddressBookDTO getEntryById(Long id) {
        AddressBookDTO entry = addressList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
        log.info("Retrieved entry for ID {}: {}", id, entry);
        return entry;
    }
}