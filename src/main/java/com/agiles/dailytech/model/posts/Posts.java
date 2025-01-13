package com.agiles.dailytech.model.posts;

import com.agiles.dailytech.auth.model.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    @ElementCollection
    @CollectionTable(name = "property_image_urls", joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;

    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key column in the Product table
    private User user;

    // No-args constructor
    public Posts() {
    }

    // All-args constructor
    public Posts(String title, List<String> imageUrls, User user) {
        this.title = title;
        this.imageUrls = imageUrls;
        this.user = user;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
