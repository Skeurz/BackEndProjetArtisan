package com.projet.artisan.services;

import com.projet.artisan.models.Post;
import com.projet.artisan.models.UserProfil;

import java.util.List;

public interface UserProfilService {


    UserProfil ajouterUserProfil(UserProfil user);

    UserProfil modiffierUserProfil( UserProfil user ,long id);
    List<UserProfil>getAllUser();

    UserProfil getUserProfilById(Long id);
   UserProfil loadUserByEmail(String email);
    Post ajouterPost(Post post);
    List<Post> getPosts();

    List<Post> getPostsByType(String type);
}
