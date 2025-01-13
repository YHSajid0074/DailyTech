package com.agiles.dailytech.auth.controller;


import com.agiles.dailytech.auth.dto.request.LoginRequestDTO;
import com.agiles.dailytech.auth.dto.response.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationController {

    ResponseEntity<LoginResponseDTO> login(LoginRequestDTO requestDTO );

}
