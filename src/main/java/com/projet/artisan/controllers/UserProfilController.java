package com.projet.artisan.controllers;

import com.projet.artisan.models.AppUser;
import com.projet.artisan.models.UserProfil;
import com.projet.artisan.services.AccountService;
import com.projet.artisan.services.UserProfilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
public class UserProfilController {


    private UserProfilService userProfilService;


    public UserProfilController(UserProfilService userProfilService) {
        this.userProfilService = userProfilService;
    }


   // @PostMapping("/ajouter")
    public UserProfil AddUserProfil(@RequestBody UserProfil user){
       return  userProfilService.ajouterUserProfil(user);

    }



    //@GetMapping("/profil/{id}")
     public UserProfil getUserProfilById(  @PathVariable Long id){
       return  userProfilService.getUserProfilById(id);

    }
   // @GetMapping("u/{email}")
    public UserProfil getUserProfilByEmail(@PathVariable String email){
        return userProfilService.loadUserByEmail(email);
    }
    //@GetMapping("utilisateurs")
    public List<UserProfil> getAllUsers(){
        return userProfilService.getAllUser();
    }
   // @PutMapping("/user/{id}")
    public UserProfil updateUserProfil( @RequestBody UserProfil userProfil,@PathVariable Long id){
        return userProfilService.modiffierUserProfil(userProfil,id);
    }

}
