package com.projet.artisan.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class AppUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name ="userName")
    private String userName;
    @Column(name = "motdepass")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> appRoles =new ArrayList<>();

    public <E> AppUser(Object o, String latifa, String latifa123, ArrayList<E> es) {
    }
}
