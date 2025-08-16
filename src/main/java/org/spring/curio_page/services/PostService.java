package org.spring.curio_page.services;


import org.spring.curio_page.model.Post;
import org.spring.curio_page.model.Post.Status;
import org.spring.curio_page.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

     // fetching the data------------------
    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

    public List<String> getAllPostsIds(){
        List<Post> allPosts = postRepo.findAll();
        List<String> postIds = new ArrayList<>();
        for (Post post : allPosts){
            String temp = post.getPost_id();
            postIds.add(temp);
        }
        return postIds;
    }

    public boolean postExistsById(String post_id){
        System.out.println("postExistsById: "+post_id);
        System.out.println(postRepo.existsById(post_id));
        return postRepo.existsById(post_id);
    }

    public List<Post> getAllPublicPosts() {
        return postRepo.findAllPublicPosts();
    }
    public List<Post> getAllPrivatePosts() {
        return postRepo.findAllPrivatePosts();
    }

    public Post getPostById(String post_id){
        if(postExistsById(post_id)){
            return postRepo.findById(post_id).get();
        }
        else{
            return null;
        }
    }

    public boolean postExistsByStatus(Status status) {
        return postRepo.existsByStatus(status);
    }

    public List<Post> getAllPostsByStatus(Status status) {
        if(postExistsByStatus(status)){
            return postRepo.findAllByStatus(status);
        }
        else return null;
    }

    public List<Post> getAllPostsByAuthorUsername(String username) {
        return postRepo.findAllPostsByAuthorUsername(username);
    }

    public List<Post> getAllPostsByCategory(String category) {
        return postRepo.findAllByCategory(category);
    }

    public List<Post> getLatestPost() {
        return postRepo.findAllByOrderByCreatedAtDesc(PageRequest.of(0, 3));
    }

    public List<Post> getFeaturedPost() {
        return postRepo.findAllByOrderByLikesDesc(PageRequest.of(0, 3));
    }

    // adding the data -----------------------------
    public Post addPost(Post post) {
        return postRepo.save(post);
    }



    // updating the data----------------
    public void toggleIsPublic(String postId) {
        Post post = postRepo.findById(postId).get();
        if(post!=null){
            boolean newValue = !post.getIsPublic();
            postRepo.updateIsPublicById(newValue, postId);
        }

    }



}
