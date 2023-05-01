package com.projet.artisan.controllers;

import com.projet.artisan.models.AppRole;
import com.projet.artisan.models.AppUser;
import com.projet.artisan.services.AccountService;
import lombok.Data;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController

public class UserController {

    private AccountService accountService;

    public UserController (AccountService accountService) {
        this.accountService = accountService;
    }
     @GetMapping(path="/users")
    // @PostAuthorize("hasAuthority('admin')")
    public List<AppUser> getAllUsers(){
        return accountService.listeUsers();
    }
    @PostMapping(path="/user")
    public AppUser ajouterUser ( @RequestBody AppUser user){

        return accountService.addUser(user);
    }
    @PostMapping(path="/roles")
    public AppRole ajouterRole ( @RequestBody AppRole role){
        return accountService.addRole(role);
    }
    @PostMapping(path="/addRoleToUser")
    public void addRoleToUser( @RequestBody RoleForm roleForm){
        accountService.addRoleToUser(roleForm.getUserName(),roleForm.getRoleName());
    }
}
@Data
class RoleForm {
    private String userName;
    private String roleName;


}