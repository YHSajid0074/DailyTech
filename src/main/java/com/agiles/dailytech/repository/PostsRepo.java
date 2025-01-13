package com.agiles.dailytech.repository;

import com.agiles.dailytech.model.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepo extends JpaRepository<Posts, Long> {
}
