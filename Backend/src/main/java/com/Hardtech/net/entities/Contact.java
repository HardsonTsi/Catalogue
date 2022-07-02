package com.Hardtech.net.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nom;

    private String prenoms;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private String email;

    private Long telephone;
    private String photo;

    public Contact(String nom, String prenoms, Date dateNaissance, String email, Long telephone, String photo) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.telephone = telephone;
        this.photo = photo;
    }

    public Contact(Long telephone, String nom) {
        this.telephone = telephone;
        this.nom = nom;
    }

}
