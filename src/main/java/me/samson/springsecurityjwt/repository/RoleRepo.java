package me.samson.springsecurityjwt.repository;

import me.samson.springsecurityjwt.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
