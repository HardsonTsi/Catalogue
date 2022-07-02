package com.Hardtech.net;

import com.Hardtech.net.entities.Contact;
import com.Hardtech.net.repos.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void addContact() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        contactRepository.save(new Contact(95710751L, "TESSI"));
        contactRepository.save(new Contact(64484940L, "ZANNOU"));
        contactRepository.save(new Contact(61767457L, "AGOSSOU"));
//        contactRepository.save(new Contact("TESSI", "Jordan Chakiris Djossè", dateFormat.parse("29/11/1998"), "jordantessi@gmail.com", 60320492L, "Photo"));
//        contactRepository.save(new Contact("AGOSSOU", "Christine Célestine Mondukpè", dateFormat.parse("06/10/1965"), "christineagossou@gmail.com", 61767457L, "Photo"));
    }

    @Test
    public List<String> getAllContactsName() {
        List<String> contactsNames = new ArrayList<>();
        contactRepository.findAll().forEach(contact -> {
            contactsNames.add(contact.toString());
        });
        return contactsNames;
    }
}
