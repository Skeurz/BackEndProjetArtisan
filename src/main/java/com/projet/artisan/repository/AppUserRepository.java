package com.projet.artisan.repository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.stereotype.Repository;
import com.projet.artisan.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projet.artisan.services.AccountServiceImpl;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
   public AppUser findByUserName( String userName);
   void deleteById(ID id);
   // AppUser delete(long id);
   // Boolean existsByUsername(String userName);

}
