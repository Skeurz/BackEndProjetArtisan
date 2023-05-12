package com.projet.artisan.services;

import com.projet.artisan.models.AppUser;
import com.projet.artisan.models.Post;

import java.util.List;

public interface ArtisanService {

    Post addPost(Post post);
    List<Post> getAllPosts();
    String updatePost(Post post);
    String deletePost(Post post);

    }
