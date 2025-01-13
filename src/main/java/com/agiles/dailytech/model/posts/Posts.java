package com.agiles.dailytech.model.posts;

import com.agiles.dailytech.auth.model.User;
import jakarta.persistence.*;

@Entity
public class Posts {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key column in the Product table
    private User user;
}
