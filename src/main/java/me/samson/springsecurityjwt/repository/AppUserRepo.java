package me.samson.springsecurityjwt.repository;

import me.samson.springsecurityjwt.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
