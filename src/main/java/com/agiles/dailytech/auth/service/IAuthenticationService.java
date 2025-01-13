package com.agiles.dailytech.auth.service;


import com.agiles.dailytech.auth.dto.request.LoginRequestDTO;
import com.agiles.dailytech.auth.dto.response.LoginResponseDTO;

public interface IAuthenticationService {
    LoginResponseDTO login(LoginRequestDTO requestDTO );
}
