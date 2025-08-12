package org.spring.curio_page.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String excerpt;
    private String category;
    private LocalDate date;
    private String readingTime;
    private String cover;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Boolean isPublic;
    private String status;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes;

    private LocalDateTime createdAt = LocalDateTime.now();
}
