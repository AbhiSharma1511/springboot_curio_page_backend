package org.spring.curio_page.controllers;

import org.spring.curio_page.model.Post;
import org.spring.curio_page.model.Post.Status;
import org.spring.curio_page.model.User;
import org.spring.curio_page.services.PostService;
import org.spring.curio_page.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    @Lazy
    private UserService userService;

    // fetching data from the posts-----------------------
    @GetMapping("/getAllPosts")
    public ResponseEntity<List<Post>> getAllPost(){
        if(postService.getAllPosts().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
        }
    }

    @GetMapping("/getAllPublicPosts")
    public ResponseEntity<List<Post>> getAllPublicPost(){
        if(postService.getAllPublicPosts().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(postService.getAllPublicPosts(), HttpStatus.OK);
        }
    }

    @GetMapping("/getAllPrivatePosts")
    public ResponseEntity<List<Post>> getAllPrivatePost(){
        if(postService.getAllPrivatePosts().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(postService.getAllPrivatePosts(), HttpStatus.OK);
        }
    }

    @GetMapping("/getAllPostsIds")
    public List<String> getAllPostsId(){
        return postService.getAllPostsIds();
    }

    @GetMapping("/getPostById/{post_id}")
    public ResponseEntity<Post> getPostById(@PathVariable String post_id){
        if(postService.postExistsById(post_id)){
            return new ResponseEntity<>(postService.getPostById(post_id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllPostsByStatus/{status}")
    public ResponseEntity<List<Post>> getAllPostsByStatus(@PathVariable Status status){
        if(postService.postExistsByStatus(status)){
            System.out.println("Status is: "+status);
            return new ResponseEntity<>(postService.getAllPostsByStatus(status), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllPostsByAuthorUsername/{username}")
    public ResponseEntity<List<Post>> getAllPostsByAuthorUsername(@PathVariable String username){
        User user = null;
        if(userService.findUserByUsername(username)){
            user  = userService.getUserByUsername(username);
            System.out.println("User is: "+user);
            if(Objects.equals(user.getRole().toString(), "AUTHOR")){
                return new ResponseEntity<>(postService.getAllPostsByAuthorUsername(username), HttpStatus.OK);
            }
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllPostsByCategory/{category}")
    public ResponseEntity<List<Post>> getAllPostsByCategory(@PathVariable String category){
        if(category!=null){
            return new  ResponseEntity<>(postService.getAllPostsByCategory(category), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getLatestPost")
    public ResponseEntity<List<Post>> getLatestPost(){
        return new ResponseEntity<>(postService.getLatestPost(), HttpStatus.OK);
    }

    @GetMapping("/getFeaturedPosts")
    public ResponseEntity<List<Post>> getFeaturedPosts(){
        return new ResponseEntity<>(postService.getFeaturedPost(), HttpStatus.OK);
    }

    // posting the data -------------------------------------------
    @PostMapping("/addPost")
    public ResponseEntity<String> addPost(@RequestBody Post post){
        if(postService.addPost(post) !=null){
            return ResponseEntity.ok().body("Post added");
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/addAllPosts")
    public ResponseEntity<String> addAllPost(@RequestBody List<Post> postList){
        int postsAdded = 0;
        for(Post post : postList){
            if(postService.addPost(post) !=null){
                postsAdded++;
            }
        }
        return new ResponseEntity<>(postsAdded+" Post added out of "+postList.size(),HttpStatus.OK);

    }

    //updating the data-----------------------------------------------
    @PostMapping("/updatePost/isPublic")
    public ResponseEntity<String> updateIsPublic(@RequestParam String post_id)
    {
        System.out.println("Post Id: "+post_id);
        if(postService.postExistsById(post_id)){
            System.out.println("Post exist with id "+post_id);
            postService.toggleIsPublic(post_id);
            return ResponseEntity.ok().body("Post updated successfully");
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }





}
