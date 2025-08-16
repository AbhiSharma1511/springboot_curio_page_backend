package org.spring.curio_page.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "likes")
public class Like {

    @Id
    private String like_id;
    private User user;
    private Post post;

}
