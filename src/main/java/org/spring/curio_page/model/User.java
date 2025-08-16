package org.spring.curio_page.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection ="users")
public class User {

    public enum Role {
        ADMIN,
        USER,
        AUTHOR
    }

    @Id
    private String user_id;

    private String name;

    @Indexed(unique = true)
    private String username;

    private Role role = Role.USER;
    private String email;
    private String password;  // store in the hashcode form
    private Integer approvals;

    @Field("isActive")
    private boolean isActive;

    private List<Integer> posts;

    private List<Integer> likePosts;

    private LocalDateTime createdAt = LocalDateTime.now();

    private Duration spendTime;

    public User() {
    }

    public User(String user_id, String name, String username, Role role, String email, String password, Integer approvals, Boolean isActive, List<Integer> posts, List<Integer> likePosts, LocalDateTime createdAt,  Duration spendTime) {
        this.user_id = user_id;
        this.name = name;
        this.username = username;
        this.role = role;
        this.email = email;
        this.password = password;
        this.approvals = approvals;
        this.isActive = isActive;
        this.posts = posts;
        this.likePosts = likePosts;
        this.createdAt = createdAt;
        this.spendTime = spendTime;
    }

    public  String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getApprovals() {
        return approvals;
    }

    public void setApprovals(Integer approvals) {
        this.approvals = approvals;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Integer> getPosts() {
        return posts;
    }

    public void setPosts(List<Integer> posts) {
        this.posts = posts;
    }

    public List<Integer> getLikePosts() {
        return likePosts;
    }

    public void setLikePosts(List<Integer> likePosts) {
        this.likePosts = likePosts;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Duration getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Duration spendTime) {
        this.spendTime = spendTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", approvals=" + approvals +
                ", isActive=" + isActive +
                ", posts=" + posts +
                ", likePosts=" + likePosts +
                ", createdAt=" + createdAt +
                ", spendTime=" + spendTime +
                '}';
    }
}
