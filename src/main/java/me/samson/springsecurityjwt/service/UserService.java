package me.samson.springsecurityjwt.service;

import me.samson.springsecurityjwt.model.AppUser;
import me.samson.springsecurityjwt.model.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    AppUser getUser(String username);
    List<AppUser>getUsers();
}
