package com.Hardtech.net.web;

import com.Hardtech.net.entities.Contact;
import com.Hardtech.net.repos.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("/contacts")
@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    /* Create */
    @PostMapping(value = "/add", consumes = "application/json")
    public Contact addContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    /*Read*/
    @GetMapping(value = "", produces = "application/json")
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    /* Read Id */
    @GetMapping(value = "/{id}", produces = "application/json")
    public Optional<Contact> getContact(@PathVariable Long id) {
        return contactRepository.findById(id);
    }

    /* Update */
    @PutMapping(value = "/update", consumes = "application/json")
    public void updateContact(@RequestBody Contact contact) {
        contactRepository.save(contact);
    }

    /* Delete */
    @DeleteMapping(value = "/delete/{id}")
    public boolean deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
        return true;
    }

    /* Find */
    @GetMapping(value = "/search")
    public List<Contact> chercher(@RequestParam(defaultValue = "", name = "key") String prenoms) {
        return contactRepository.findByPrenomsLikeOrNomLike("%" + prenoms + "%", "%" + prenoms + "%");
    }

}
