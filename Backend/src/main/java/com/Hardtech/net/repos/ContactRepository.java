package com.Hardtech.net.repos;

import com.Hardtech.net.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByPrenomsLike(String Prenoms);
}
