package org.spring.curio_page.repo;

import org.spring.curio_page.model.Like;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LikeRepo extends MongoRepository<Like,Integer> {
}
