package com.agiles.dailytech.service;

import com.agiles.dailytech.dto.request.PostsRequestDto;
import com.agiles.dailytech.dto.response.PostsResponseDto;
import com.agiles.dailytech.model.posts.Posts;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PostsService {
    void savePosts(PostsRequestDto postsRequestDto,List<MultipartFile> additionalImagesFiles) throws IOException;
    List<PostsResponseDto> getAllPosts();
    void deletePosts(Long id);
    void updatePosts(Long id,PostsRequestDto postsRequestDto,List<MultipartFile> additionalImagesFiles) throws IOException;
    PostsResponseDto findById(Long id);

}
