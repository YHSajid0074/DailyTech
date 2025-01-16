package com.agiles.dailytech.dto.response;

import com.agiles.dailytech.auth.dto.response.CustomUserResponseDTO;
import com.agiles.dailytech.auth.model.User;

import java.util.List;

public interface PostsResponseDto {

    String getTitle();

    List<String> getImageUrls();

     CustomUserResponseDTO getUser();
}
