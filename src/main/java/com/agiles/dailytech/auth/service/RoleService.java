package com.agiles.dailytech.auth.service;


import com.agiles.dailytech.auth.dto.response.CustomRoleResponseDTO;

public interface RoleService {

    public CustomRoleResponseDTO readOne(Long id );
    public String delete( Long id );

}
