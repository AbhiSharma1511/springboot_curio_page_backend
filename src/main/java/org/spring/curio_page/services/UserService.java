package org.spring.curio_page.services;

import org.spring.curio_page.model.User;
import org.spring.curio_page.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public ResponseEntity<String> addUser(User user) {
        if(userRepo.existsByUsernameLike(user.getUsername())) {
            return new ResponseEntity<>("Username already exists", HttpStatus.CONFLICT);
        }
        else if(userRepo.existsUserByEmailIsLike(user.getEmail())) {
            return new  ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
        }
        else {
            userRepo.save(user);
            return new ResponseEntity<>("Successfully added", HttpStatus.CREATED);
        }
    }

    public ResponseEntity<String> loginUser(String username, String password) {

        if(userRepo.existsByUsernameLike(username)
                && userRepo.existsUserByPassword(password)) {
            return new ResponseEntity<>("Successfully Login", HttpStatus.OK);
        }
        else{
            return new  ResponseEntity<>("User not found, invalid credentials", HttpStatus.NOT_FOUND);
        }
    }

    public boolean findUserByUsername(String username) {
        return userRepo.existsByUsernameLike(username);
    }

    public User getUserByUsername(String username) {
        if(userRepo.existsByUsernameLike(username)) {
            return userRepo.getUserByUsername(username);
        }
        return null;
    }

    public boolean deleteUser(String username, String email) {
        return true;
    }
}
