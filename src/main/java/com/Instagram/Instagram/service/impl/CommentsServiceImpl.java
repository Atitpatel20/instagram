package com.Instagram.Instagram.service.impl;

import com.Instagram.Instagram.entity.Comment;
import com.Instagram.Instagram.entity.Instagram;
import com.Instagram.Instagram.exception.ResourceNotFoundException;
import com.Instagram.Instagram.payload.CommentsDto;
import com.Instagram.Instagram.repository.CommentsRepository;
import com.Instagram.Instagram.repository.InstagramRepository;
import com.Instagram.Instagram.service.CommentsService;
import org.springframework.stereotype.Service;
@Service
public class CommentsServiceImpl implements CommentsService {

    private InstagramRepository instagramRepository;
    private CommentsRepository commentsRepository;

    public CommentsServiceImpl(InstagramRepository instagramRepository, CommentsRepository commentsRepository) {
        this.instagramRepository = instagramRepository;
        this.commentsRepository = commentsRepository;
    }

    @Override
    public CommentsDto createComments(CommentsDto commentsDto, long instagramId) {
        Instagram instagram = instagramRepository.findById(instagramId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id: " + instagramId)
        );

        Comment comment = new Comment();
        comment.setEmail(commentsDto.getEmail());
        comment.setText(commentsDto.getText());
        comment.setInstagram(instagram);
        Comment savedComment = commentsRepository.save(comment);

        CommentsDto dto = new CommentsDto();
        dto.setId(savedComment.getId());
        dto.setEmail(savedComment.getEmail());
        dto.setText(savedComment.getText());

        return dto;
    }
}
