package com.Hardtech.net.web;

import com.Hardtech.net.entities.Contact;
import com.Hardtech.net.repos.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    /* Create */
    @PostMapping(value = "/contacts/add", consumes = "application/json")
    public Contact addContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    /*Read*/
    @GetMapping(value = "/contacts", produces = "application/json")
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    /* Read Id */
    @GetMapping(value = "/contacts/{id}", produces = "application/json")
    public Optional<Contact> getContact(@PathVariable Long id) {
        return contactRepository.findById(id);
    }

    /* Update */
    @PutMapping(value = "/contacts/update", consumes = "application/json")
    public void updateContact(@RequestBody Contact contact) {
        contactRepository.save(contact);
    }

    /* Delete */
    @DeleteMapping(value = "/contacts/delete/{id}")
    public boolean deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
        return true;
    }

    /* Find */
    @GetMapping(value = "/contacts/search")
    public List<Contact> chercher(@RequestParam(defaultValue = "") String prenoms) {
        return contactRepository.findByPrenomsLike("%" + prenoms + "%");
    }

}
