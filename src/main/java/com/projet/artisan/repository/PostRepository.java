package com.projet.artisan.repository;

import com.projet.artisan.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    public List<Post> findByType(String type);


}
