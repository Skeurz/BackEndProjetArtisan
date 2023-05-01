package com.projet.artisan.repository;

import com.projet.artisan.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByUserName( String userName);

}
