package com.projet.artisan.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="post")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Post {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String type;
     private String artisant;
     private String titreAnnonce;
     private String description;
     private String ville;
     private String imgUrl;
     private Long prix;

}
