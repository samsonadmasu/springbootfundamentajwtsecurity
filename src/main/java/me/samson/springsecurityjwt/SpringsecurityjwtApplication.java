package me.samson.springsecurityjwt;

import me.samson.springsecurityjwt.model.AppUser;
import me.samson.springsecurityjwt.model.Role;
import me.samson.springsecurityjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringsecurityjwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityjwtApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null,"Samson1 admasu","sami1","1234",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Samson2 admasu","sami2","1234",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Samson3 admasu","sami3","1234",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Samson4 admasu","sami4","1234",new ArrayList<>()));

			userService.addRoleToUser("sami1","ROLE_USER");
			userService.addRoleToUser("sami2","ROLE_MANAGER");
			userService.addRoleToUser("sami2","ROLE_USER");
			userService.addRoleToUser("sami3","ROLE_ADMIN");
			userService.addRoleToUser("sami4","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("sami4","ROLE_ADMIN");
			userService.addRoleToUser("sami4","ROLE_MANAGER");


		};
	}
}
