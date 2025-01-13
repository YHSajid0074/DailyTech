package com.agiles.dailytech.dto.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record PostsRequestDto(
        String title,
        List<MultipartFile> imageUrls,
        String username
){

}
