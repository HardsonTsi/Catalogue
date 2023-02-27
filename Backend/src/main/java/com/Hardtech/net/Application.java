package com.Hardtech.net;

import com.Hardtech.net.entities.Contact;
import com.Hardtech.net.repos.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
@AllArgsConstructor
public class Application{


    private final ContactRepository contactRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void run() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        contactRepository.save(new Contact("AVAHOUN", "Constant", dateFormat.parse("05/11/1960"), "constanttessi@gmail.com", 97818403L, "photo.JPEG"));
        contactRepository.save(new Contact("AVAHOUN", "Josephine", dateFormat.parse("05/11/1940"), "josephine@gmail.com", 9324281803L, "photo.JPEG"));
        contactRepository.save(new Contact("AGOSSOU", "Christine", dateFormat.parse("06/10/1966"), "christinagossou@gmail.com", 61767457L, "photo.JPEG"));
        contactRepository.save(new Contact("AGOSSOU", "Bezos", dateFormat.parse("06/10/1967"), "bezos@gmail.com", 6539457L, "photo.JPEG"));
        contactRepository.save(new Contact("TESSI", "Jordan", dateFormat.parse("29/11/1998"), "jordantessi@gmail.com", 60320492L, "photo.JPEG"));
        contactRepository.save(new Contact("TESSI", "Bill", dateFormat.parse("29/11/1958"), "billtessi@gmail.com", 63420882L, "photo.JPEG"));
        contactRepository.save(new Contact("ZANNOU", "Hardson", dateFormat.parse("24/02/2002"), "hardsontessi@gmail.com", 95710751L, "photo.JPEG"));
        contactRepository.save(new Contact("TALON", "Patrice", dateFormat.parse("01/07/1962"), "patricetalon@gmail.com", 60320492L, "photo.JPEG"));
    }
}
