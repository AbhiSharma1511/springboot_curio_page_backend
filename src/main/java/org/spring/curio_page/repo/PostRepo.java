package org.spring.curio_page.repo;

import org.spring.curio_page.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PostRepo extends MongoRepository<Post,String> {

    @Query(value = "{}", fields = "{'post_id' : 1}")
    List<Post> findAllPostIds();

    @Query("{ 'post_id' : ?1 }")
    @Update("{ '$set': { 'isPublic': ?0 } }")
    void updateIsPublicById(Boolean isPublic, String postId);

    @Query("{'isPublic': true}")
    List<Post> findAllPublicPosts();

    @Query("{'isPublic': false}")
    List<Post> findAllPrivatePosts();

    List<Post> findAllPostsByAuthorUsername(String authorUsername);

    boolean existsByStatus(Post.Status status);
    List<Post> findAllByStatus(Post.Status status);

    List<Post> findAllByCategory(String category);

    List<Post> findAllByOrderByCreatedAtDesc(Pageable pageable);

    List<Post> findAllByOrderByLikesDesc(Pageable pageable);
}
