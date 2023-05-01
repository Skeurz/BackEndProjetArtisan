package com.projet.artisan.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="userProfil")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserProfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name ="username")
    private String userName;
    @Column(name = "motdepass")
    private String motdepass;
    private String email;
    private String tel;
    private String ville ;
    private String artisan;
    private String imgUrl ;


}