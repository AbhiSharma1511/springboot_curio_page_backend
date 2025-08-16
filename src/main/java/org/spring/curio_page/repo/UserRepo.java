package org.spring.curio_page.repo;

import org.spring.curio_page.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    boolean existsUserByEmailIsLike(String email);
    boolean existsByUsernameLike(String username);
    boolean existsUserByPassword(String password);

    boolean findUserByUsername(String username);

    User username(String username);

    User getUserByUsername(String username);
}
