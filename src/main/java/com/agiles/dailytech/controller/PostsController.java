package com.agiles.dailytech.controller;


import com.agiles.dailytech.dto.request.PostsRequestDto;
import com.agiles.dailytech.dto.response.PostsResponseDto;
import com.agiles.dailytech.service.PostsService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("Posts")
@RestController
public class PostsController {

    PostsService postsService;
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> create(@ModelAttribute PostsRequestDto postsRequestDto) throws IOException {
        postsService.savePosts(postsRequestDto,postsRequestDto.imageUrls());
        return ResponseEntity.ok().body("Posts created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>delete(@PathVariable Long id){
        postsService.deletePosts(id);
        return ResponseEntity.ok().body("Posts deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostsResponseDto> getPosts(@PathVariable Long id){
       return ResponseEntity.ok( postsService.findById(id));
    }

    @GetMapping("/All")
    public ResponseEntity<List<PostsResponseDto>> getPosts(){
        return ResponseEntity.ok(postsService.getAllPosts());
    }

    @PatchMapping
    public ResponseEntity<String>update(@PathVariable Long id,@ModelAttribute PostsRequestDto postsRequestDto) throws IOException {
        postsService.savePosts(postsRequestDto,postsRequestDto.imageUrls());
        return ResponseEntity.ok().body("Posts updated");
    }
}
