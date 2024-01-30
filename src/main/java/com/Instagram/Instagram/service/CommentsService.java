package com.Instagram.Instagram.service;

import com.Instagram.Instagram.payload.CommentsDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommentsService {
    CommentsDto createComments(
            CommentsDto commentsDto,
             long instagramId);

    void deleteComment(long id);

    CommentsDto updateComment(long id, CommentsDto commentsDto, long instagramId);
}
