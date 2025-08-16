package org.spring.curio_page.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "posts")
public class Post {

    public enum Status {
        Pending,
        Approved,
        Rejected
    }

    @Id
    private String post_id;
    private String title;
    private String excerpt;
    private String category;
    private LocalDate date;
    private String readingTime;
    private String cover;

    private String content;

    @Field("isPublic")
    private Boolean isPublic;

    private Status status = Status.Pending;

    private String authorUsername;

    private List<Comment> comments;

    private List<Like> likes;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Post() {
    }

    public Post(String post_id, String title, String excerpt, String category, LocalDate date, String readingTime, String cover, String content, Boolean isPublic, Status status, String authorUsername, List<Comment> comments, List<Like> likes, LocalDateTime createdAt) {
        this.post_id = post_id;
        this.title = title;
        this.excerpt = excerpt;
        this.category = category;
        this.date = date;
        this.readingTime = readingTime;
        this.cover = cover;
        this.content = content;
        this.isPublic = isPublic;
        this.status = status;
        this.authorUsername = authorUsername;
        this.comments = comments;
        this.likes = likes;
        this.createdAt = createdAt;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(String readingTime) {
        this.readingTime = readingTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id='" + post_id + '\'' +
                ", title='" + title + '\'' +
                ", excerpt='" + excerpt + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", readingTime='" + readingTime + '\'' +
                ", cover='" + cover + '\'' +
                ", content='" + content + '\'' +
                ", isPublic=" + isPublic +
                ", status='" + status + '\'' +
                ", authorUsername='" + authorUsername + '\'' +
                ", comments=" + comments +
                ", likes=" + likes +
                ", createdAt=" + createdAt +
                '}';
    }
}
