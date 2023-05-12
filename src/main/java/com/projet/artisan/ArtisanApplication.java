package com.projet.artisan;

import com.projet.artisan.models.AppRole;
import com.projet.artisan.models.AppUser;
import com.projet.artisan.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;


@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)

public class ArtisanApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run( ArtisanApplication.class, args);

	}
	@Bean
	PasswordEncoder passwordEncoder (){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner start (AccountService accountService){

return args-> {
		accountService.addRole(new AppRole(null, "admin"));
		accountService.addRole(new AppRole(null, "client"));
		//²accountService.addRole(new AppRole(null, "artisant"));

	   accountService.addUser(new AppUser(null,"latifa","latifa","lhafidi@gmail.com","latifa","latifa123", new ArrayList<>()));
	    accountService.addUser(new AppUser(null,"soufiane","lhafidi","mahzinho59@gmail.com","soufiane","ahmed2022", new ArrayList<>()));

		accountService.addRoleToUser("latifa", "admin");
		accountService.addRoleToUser("soufiane","client");



};
	}
}


