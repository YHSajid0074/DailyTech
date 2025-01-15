package com.agiles.dailytech.model.posts;

import com.agiles.dailytech.auth.model.User;
import com.agiles.dailytech.model.votes.Votes;
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
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "votes_id", referencedColumnName = "id")
//    private Votes votes;


    public Posts() {
    }


    public Posts(String title, List<String> imageUrls, User user) {
        this.title = title;
        this.imageUrls = imageUrls;
        this.user = user;
//        this.votes = votes;
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

//    public Votes getVotes() {
//        return votes;
//    }
//    public void setVotes(Votes votes) {
//        this.votes = votes;
//    }
}
