package com.projet.artisan.services;

import com.projet.artisan.models.AppRole;
import com.projet.artisan.models.AppUser;
import com.projet.artisan.repository.AppUserRepository;

import java.util.List;

public interface AccountService {
    default void deleteUser(Long id) {
    }
    //static AppUser deleteUser(int id);

    AppUser addUser(AppUser user);
    AppUser getUser(Long id);

    public AppUser updateUser(AppUser user);

    AppUser getUserById(Long id);

    AppUser saveUser(AppUser user);


    AppRole addRole(AppRole role);

    List<AppUser> listeUsers();
    AppUser loadUserByUserName(String userName);

 //   AppUser delete(Long id);

    void addRoleToUser(String userName, String role);


}
