package com.projet.artisan.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.projet.artisan.ArtisanApplication;
import com.projet.artisan.models.AppRole;
import com.projet.artisan.models.AppUser;
import com.projet.artisan.repository.AppUserRepository;
import com.projet.artisan.services.AccountService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="http://localhost:4200")

@RestController

public class UserController {

    private AccountService accountService;
    private final AppUserRepository appUserRepository;
    private  final AuthenticationManager authenticationManager;

    public UserController(AccountService accountService, AuthenticationManager authenticationManager, AppUserRepository appUserRepository) {
        this.accountService = accountService;
        this.authenticationManager = authenticationManager;
        this.appUserRepository = appUserRepository;
    }



    @GetMapping(path="/users")
   // @PostAuthorize("hasAuthority('user')")
    public List<AppUser> getAllUsers(){
        return accountService.listeUsers();
    }





    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        accountService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, String>> generateToken(@RequestBody AppUser authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid username/password");
        }

        String token = generateJWT(authRequest.getUserName());

        // Créer une map contenant le token
        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        // Renvoyer une réponse JSON contenant la map
        return ResponseEntity.ok().body(response);
    }
    private String generateJWT(String username) {
        String secret = "mysecret123";
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 1000 * 60 * 60 * 10); // 10 hours from now

        // Build the JWT claims
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", username);
        claims.put("exp", expiryDate);

        // Build the JWT and sign it with the secret key
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create()
                .withIssuer("mysecret123")
                .withHeader(null)
                .withClaim("payload", claims)
                .sign(algorithm);
        return token;
    }
    @GetMapping (path="/profil/{id}")    public AppUser getUserById( @PathVariable Long id){
        return accountService.getUser(id);
    }


    @PutMapping("edit/{id}")
    public ResponseEntity<AppUser> updateUser(@PathVariable Long id, @RequestBody AppUser updatedUser) {
        AppUser user = accountService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        user.setNom(updatedUser.getNom());
        user.setPrenom(updatedUser.getPrenom());
        user.setUserName(updatedUser.getUserName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());

        AppUser updatedAppUser = accountService.updateUser(user);
        return ResponseEntity.ok(updatedAppUser);
    }





    private AppUserRepository repo;
    @PostMapping(path="/register")
    public AppUser appUser ( @RequestBody AppUser user){
       return accountService.addUser(user);
        //  return ResponseEntity.ok(repo.save(user));
    }
    @PostMapping(path="/roles")
    public AppRole appRole ( @RequestBody AppRole role){
        return accountService.addRole(role);
    }
    @PostMapping(path="/addRoleToUser")
    public void addRoleToUser( @RequestBody RoleForm roleForm){
        accountService.addRoleToUser(roleForm.getUserName(),roleForm.getRoleName());
    }



   /* @DeleteMapping (path="/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
         AccountService.deleteUser((int) id);
        return "User Deleted Successfully";
    }*/
}
@Data
class RoleForm{
    private String userName;
    private String roleName;


}