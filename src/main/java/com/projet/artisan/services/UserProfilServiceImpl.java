package com.projet.artisan.services;

import com.projet.artisan.models.Post;
import com.projet.artisan.models.UserProfil;
import com.projet.artisan.repository.PostRepository;
import com.projet.artisan.repository.UserProfilRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserProfilServiceImpl implements UserProfilService{
    private UserProfilRepository userProfilRepository;
    private PostRepository postRepository;

    public UserProfilServiceImpl(UserProfilRepository userProfilRepository, PostRepository postRepository) {
        this.userProfilRepository = userProfilRepository;
        this.postRepository = postRepository;
    }



    @Override
    public UserProfil ajouterUserProfil(UserProfil user) {
       return  userProfilRepository.save(user);

    }

    @Override
    public UserProfil modiffierUserProfil(UserProfil user, long id) {
        UserProfil user1=userProfilRepository.findById(id).get();
        user1.setNom(user.getNom());
        user1.setPrenom(user.getPrenom());
        user1.setUserName(user.getUserName());
        user1.setVille(user.getVille());
        user1.setTel(user.getTel());
        user1.setEmail(user.getEmail());
        return  userProfilRepository.save(user);
    }




    @Override
    public UserProfil getUserProfilById(Long id) {
        return  userProfilRepository.findById(id).get();

    }

    @Override
    public UserProfil loadUserByEmail(String email) {

        return userProfilRepository.findByEmail(email);
    }

    @Override
    public List<UserProfil> getAllUser() {

        return userProfilRepository.findAll();
    }
    @Override
    public Post ajouterPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getPosts() {
         return postRepository.findAll();
    }

    @Override
    public List<Post> getPostsByType( String type) {
        return postRepository.findByType(type);

    }


}
