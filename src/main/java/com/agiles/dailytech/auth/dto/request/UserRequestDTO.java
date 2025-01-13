package com.agiles.dailytech.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 *
 */

public record UserRequestDTO(

        @NotEmpty(message = "Username can't be null or empty.")
        String username,

        @NotEmpty(message = "Email address can't be null or empty.")
        @Email(message = "Enter a valid email address.")
        String email,

        @NotEmpty(message = "Password can't be null or empty.")
        String password,

        MultipartFile profilpic,

        String address,

        String phone,

        String bio,

        String profession,

        String fullname

) implements Serializable {
}