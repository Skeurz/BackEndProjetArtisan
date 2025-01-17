package com.projet.artisan.services;

import com.projet.artisan.models.AppUser;
import com.projet.artisan.models.Post;
import com.projet.artisan.repository.PostRepository;

import java.util.List;

public interface ArtisanService {

    Post addPost(Post post);
    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post getPost(Long id);

    public Post updatePost(Post post);

    default void deletePost(Long id) {
    }

    }
