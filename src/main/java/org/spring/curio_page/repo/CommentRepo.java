package org.spring.curio_page.repo;

import org.spring.curio_page.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepo extends MongoRepository<Comment,Integer> {
}
