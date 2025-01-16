package com.agiles.dailytech.service;

import com.agiles.dailytech.dto.request.VotesRequestDto;

public interface VotesService {
    void create(VotesRequestDto requestDto);
    void getVotesByPostId(Long postId);
}
