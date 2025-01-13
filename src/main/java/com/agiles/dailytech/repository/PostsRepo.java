package com.agiles.dailytech.repository;

import com.agiles.dailytech.dto.response.PostsResponseDto;
import com.agiles.dailytech.model.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostsRepo extends JpaRepository<Posts, Long> {

    @Query("""
              select p FROM Posts p WHERE p.id = :id
            """)
    Optional<PostsResponseDto> getPostsById(Long id);

    @Query("""
            select p from Posts p
            """)
    List<PostsResponseDto> getAllPosts();

}
