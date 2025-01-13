package com.agiles.dailytech.service.impl;

import com.agiles.dailytech.auth.repository.UserRepo;
import com.agiles.dailytech.dto.request.PostsRequestDto;
import com.agiles.dailytech.dto.response.PostsResponseDto;
import com.agiles.dailytech.model.posts.Posts;
import com.agiles.dailytech.repository.PostsRepo;
import com.agiles.dailytech.service.CloudneryImageService;
import com.agiles.dailytech.service.PostsService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PostsServiceImpl implements PostsService {

    PostsRepo postsRepo;
    UserRepo userRepo;
    CloudneryImageService cloudneryImageService;

    public PostsServiceImpl(PostsRepo postsRepo,UserRepo userRepo,CloudneryImageService cloudneryImageService) {
        this.postsRepo = postsRepo;
        this.userRepo = userRepo;
        this.cloudneryImageService = cloudneryImageService;
    }

    public Posts convertToEntity(Posts posts,PostsRequestDto postsRequestDto,List<MultipartFile> additionalImagesFiles) throws IOException {

        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile file : additionalImagesFiles) {
            Map<String, Object> uploadResult = cloudneryImageService.upload(file);
            String imageUrl = (String) uploadResult.get("secure_url");
            imageUrls.add(imageUrl);
        }

        posts.setUser(userRepo.findByUsername(postsRequestDto.username()));
        posts.setTitle(postsRequestDto.title());
        posts.setImageUrls(imageUrls);
         postsRepo.save(posts);
         return posts;
    }


    @Override
    public void savePosts(PostsRequestDto postsRequestDto,List<MultipartFile> additionalImagesFiles) throws IOException {
        Posts posts = convertToEntity(new Posts(),postsRequestDto,additionalImagesFiles);
        postsRepo.save(posts);
    }

    @Override
    public List<PostsResponseDto> getAllPosts() {
        return postsRepo.getAllPosts();
    }

    @Override
    public void deletePosts(Long id) {
       postsRepo.deleteById(id);
    }

    @Override
    public void updatePosts(Long id,PostsRequestDto postsRequestDto,List<MultipartFile> additionalImagesFiles) throws IOException {

        Posts posts = postsRepo.findById(id).orElse(null);
        Posts updatedPosts = convertToEntity(posts,postsRequestDto,additionalImagesFiles);
        postsRepo.save(updatedPosts);
    }

    @Override
    public PostsResponseDto findById(Long id) {
        return postsRepo.getPostsById(id).orElse(null);
    }
}
