package org.spring.curio_page.services;

import org.spring.curio_page.model.User;
import org.spring.curio_page.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public boolean addUser(User user) {
        if(userRepo.save(user)!=null){
            return true;
        };
        return false;
    }

}
