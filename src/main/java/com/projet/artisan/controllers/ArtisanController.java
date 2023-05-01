package com.projet.artisan.controllers;

import com.projet.artisan.models.Post;
import com.projet.artisan.services.UserProfilService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController

public class ArtisanController {
    private UserProfilService userProfilService;

    public ArtisanController(UserProfilService userProfilService) {
        this.userProfilService = userProfilService;
    }
    @PostMapping("/offre")

    public Post ajouterPost(@RequestBody Post post){
        return  userProfilService.ajouterPost(post);
    }

    @GetMapping("/posts")
    public List<Post> afficherPost(){
        List<Post> list= userProfilService.getPosts();
        return list;
    }
    @GetMapping("posts/{type}")
    public List<Post> afficherPostByType( @PathVariable String type){
        List<Post> list= userProfilService.getPostsByType(type);
        return list;

}}
