package com.projet.artisan.services;

import com.projet.artisan.models.AppRole;
import com.projet.artisan.models.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addUser(AppUser user);
    AppUser getUser(Long id);

    AppRole addRole(AppRole role);

    List<AppUser> listeUsers();
    AppUser loadUserByUserName(String userName);
    void addRoleToUser(String userName,String role);
}
