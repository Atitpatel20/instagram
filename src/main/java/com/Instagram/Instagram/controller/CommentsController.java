package com.Instagram.Instagram.controller;

import com.Instagram.Instagram.payload.CommentsDto;
import com.Instagram.Instagram.service.CommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    private CommentsService commentsService;
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }
// http://localhost:8080/api/comments?instagramId=1
    @PostMapping
    public ResponseEntity<CommentsDto>createComments(
            @RequestBody CommentsDto commentsDto,
            @RequestParam long instagramId
            ){
        CommentsDto dtos = commentsService.createComments(commentsDto, instagramId);
        return new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteComment(@PathVariable long id){
        commentsService.deleteComment(id);
        return new ResponseEntity<>("Record is deleted",HttpStatus.OK);
    }
    // http://localhost:8080/api/comments/1/instagram/1
    @PutMapping("/{id}/instagram/{instagramId}")
    public ResponseEntity<CommentsDto>updateComment(@PathVariable long id,@RequestBody CommentsDto commentsDto,@PathVariable long instagramId){
        CommentsDto dtos= commentsService.updateComment(id,commentsDto,instagramId);
        return new ResponseEntity<>(dtos,HttpStatus.OK);
    }
}
