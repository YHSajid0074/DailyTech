package com.agiles.dailytech.auth.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record UserUpdateRequestDto(

        MultipartFile profilpic,

        String address,

        String phone,

        String bio,

        Long sold,

        String profession,

        String fullname,

        MultipartFile coverPic
) {

}
