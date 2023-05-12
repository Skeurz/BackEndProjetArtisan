package com.projet.artisan.services;

import com.projet.artisan.models.AppRole;
import com.projet.artisan.models.AppUser;
import com.projet.artisan.repository.AppRoleRepository;
import com.projet.artisan.repository.AppUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional

public class AccountServiceImpl implements AccountService {
    private AppRoleRepository appRoleRepository;
    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;



    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository=appRoleRepository;
        this.passwordEncoder = passwordEncoder;

    }


    @Override
    public AppUser addUser(AppUser user) {
        String pw= user.getPassword();
        user.setPassword(passwordEncoder.encode(pw));
        return appUserRepository.save(user);
    }

    @Override
    public AppUser getUser(Long id) {
        return appUserRepository.findById(id).get();
    }


    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppUser user= appUserRepository.findByUserName(userName);
        AppRole role= appRoleRepository.findByRole(roleName);
        user.getAppRoles().add(role);


    }

    @Override
    public AppRole addRole(AppRole role) {

        return appRoleRepository.save(role);
    }

    @Override
    public List<AppUser> listeUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser loadUserByUserName(String userName) {
        return appUserRepository.findByUserName(userName);
    }


}
