package com.av.psytest.server.services;

import com.av.psytest.server.exceptions.UserAlreadyExistsException;
import com.av.psytest.server.models.Role;
import com.av.psytest.server.models.User;
import com.av.psytest.server.repositories.RoleRepository;
import com.av.psytest.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private UserRepository userRepo;
    private RoleRepository roleRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    public void setRoleRepo(RoleRepository roleRepo) {
        this.roleRepo = roleRepo;
    }

    public void save(User user) throws UserAlreadyExistsException {
        if (userRepo.existsByUsername(user.getUsername())) {
            throw new UserAlreadyExistsException("User with email " +
                    user.getUsername() + " already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepo.findByName("ROLE_USER"));
        user.setRoles(roles);
        userRepo.save(user);
    }

    public Page<User> getAll(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    public User getById(Long id) {
        return userRepo.findById(id).get();
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    public User FindByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public List<User> getUsersByDateBetweenAndGender(Boolean sex,
                                                     Date minDate,
                                                     Date maxDate) {
        return userRepo.findByDateOfBirthBetweenAndSexIs(minDate, maxDate, sex);
    }

    public void changePass(String username, String password) {
        User curUser = FindByUsername(username);
        curUser.setPassword(passwordEncoder.encode(curUser.getPassword()));
    }
}