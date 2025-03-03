package com.bridgelabz.springaddressbookapplication.service;


import com.bridgelabz.springaddressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.springaddressbookapplication.exceptionhandler.AddressBookNotFoundException;
import com.bridgelabz.springaddressbookapplication.model.AddressBook;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class AddressBookService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public AddressBook addEntry(AddressBookDTO dto) {
        AddressBook entry = new AddressBook();
        entry.setName(dto.getName());
        entityManager.persist(entry);
        return entry;
    }


    @Transactional
    public List<AddressBook> getAllEntries() {  // Fix: Marked as @Transactional
        log.info("Fetching all entries");
        return entityManager.createQuery("SELECT a FROM AddressBook a", AddressBook.class).getResultList();
    }

    public AddressBook getEntryById(Long id) {
        AddressBook entry = entityManager.find(AddressBook.class, id);
        if (entry == null) {
            throw new AddressBookNotFoundException("AddressBook entry with ID " + id + " not found.");
        }
        return entry;
    }


    @Transactional
    public AddressBook updateEntry(Long id, AddressBookDTO dto) {
        AddressBook entry = entityManager.find(AddressBook.class, id);
        if (entry != null) {
            entry.setName(dto.getName());
        }
        return entry;
    }

    @Transactional
    public boolean deleteEntry(Long id) {
        AddressBook entry = entityManager.find(AddressBook.class, id);
        if (entry != null) {
            entityManager.remove(entry);
            log.info("Deleted entry with ID: {}", id);
            return true;
        }
        return false;
    }
}