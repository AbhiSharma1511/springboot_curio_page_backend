package org.spring.curio_page.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "comments")
public class Comment {

    @Id
    private String comment_id;

    private Post post;
    private User user;

    private Comment parentComment;
    private List<Comment> replies = new ArrayList<>();

    private String comment;

    private LocalDateTime createdAt = LocalDateTime.now();
}
