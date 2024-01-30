package com.Instagram.Instagram.service.impl;

import com.Instagram.Instagram.entity.Comment;
import com.Instagram.Instagram.entity.Instagram;
import com.Instagram.Instagram.exception.ResourceNotFoundException;
import com.Instagram.Instagram.payload.CommentsDto;
import com.Instagram.Instagram.repository.CommentsRepository;
import com.Instagram.Instagram.repository.InstagramRepository;
import com.Instagram.Instagram.service.CommentsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
@Service
public class CommentsServiceImpl implements CommentsService {

    private InstagramRepository instagramRepository;
    private CommentsRepository commentsRepository;
    private ModelMapper modelMapper;

    public CommentsServiceImpl(InstagramRepository instagramRepository, CommentsRepository commentsRepository, ModelMapper modelMapper) {
        this.instagramRepository = instagramRepository;
        this.commentsRepository = commentsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentsDto createComments(CommentsDto commentsDto, long instagramId) {
        Instagram instagram = instagramRepository.findById(instagramId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id: " + instagramId)
        );
        Comment c = mapToEntity(commentsDto);

//        Comment comment = new Comment();
//        comment.setEmail(commentsDto.getEmail());
//        comment.setText(commentsDto.getText());
        c.setInstagram(instagram);
        Comment savedComment = commentsRepository.save(c);

//        CommentsDto dto = new CommentsDto();
//        dto.setId(savedComment.getId());
//        dto.setEmail(savedComment.getEmail());
//        dto.setText(savedComment.getText());

        return mapToDto(savedComment);
    }

    @Override
    public void deleteComment(long id) {
        commentsRepository.deleteById(id);
    }

    @Override
    public CommentsDto updateComment(long id, CommentsDto commentsDto, long instagramId) {
        Instagram instagram = instagramRepository.findById(instagramId).orElseThrow(
                () -> new ResourceNotFoundException("user not found with id" + instagramId)
        );
        Comment comment = commentsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("comment not found with id" + id)
        );
        Comment c = mapToEntity(commentsDto);
        c.setId(comment.getId());
        c.setInstagram(instagram);
        Comment update = commentsRepository.save(c);
        return mapToDto(update);
    }

    CommentsDto mapToDto(Comment comment) {
        CommentsDto dto = modelMapper.map(comment, CommentsDto.class);
        return dto;
    }

    Comment mapToEntity(CommentsDto commentsDto) {
        Comment comment = modelMapper.map(commentsDto, Comment.class);
        return comment;
    }


}
