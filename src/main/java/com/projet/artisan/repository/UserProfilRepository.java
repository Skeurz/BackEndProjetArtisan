package com.projet.artisan.repository;

import com.projet.artisan.models.AppUser;
import com.projet.artisan.models.UserProfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfilRepository extends JpaRepository<UserProfil,Long> {
    public UserProfil findByEmail(String email);


}
