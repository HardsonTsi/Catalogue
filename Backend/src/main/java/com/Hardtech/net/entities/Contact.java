package com.Hardtech.net.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String nom;

    String prenoms;

    @Temporal(TemporalType.DATE)
    Date dateNaissance;

    String email;

    Long telephone;
    String photo;

    public Contact(String nom, String prenoms, Date dateNaissance, String email, Long telephone, String photo) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.telephone = telephone;
        this.photo = photo;
    }

}
