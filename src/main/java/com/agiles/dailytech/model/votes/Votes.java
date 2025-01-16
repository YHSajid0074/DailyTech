package com.agiles.dailytech.model.votes;

import com.agiles.dailytech.model.posts.Posts;
import jakarta.persistence.*;

@Entity
public class Votes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long upvotes;
    private Long downvotes;
    private Long totalvotes;


    @OneToOne(mappedBy = "votes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Posts post;

    public Votes() {
    }

    public Votes(Long id, Long upvotes, Long downvotes, Long totalvotes,Posts post) {
        this.id = id;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.totalvotes = totalvotes;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Long upvotes) {
        this.upvotes = upvotes;
    }

    public Long getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Long downvotes) {
        this.downvotes = downvotes;
    }

    public Long getTotalvotes() {
        return totalvotes;
    }

    public void setTotalvotes(Long totalvotes) {
        this.totalvotes = totalvotes;
    }

    public Posts getPost() {
        return post;
    }

    public void setPost(Posts post) {
        this.post = post;
    }
}
