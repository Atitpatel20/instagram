package com.Instagram.Instagram.controller;

import com.Instagram.Instagram.entity.Instagram;
import com.Instagram.Instagram.payload.InstagramDto;
import com.Instagram.Instagram.service.InstagramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/igUsers")
public class InstagramController {

    InstagramService instagramService;

    public InstagramController(InstagramService instagramService) {
        this.instagramService = instagramService;
    }

    @PostMapping
    public ResponseEntity<InstagramDto> createUser(@RequestBody InstagramDto instagramDto) {
        InstagramDto users = instagramService.createUser(instagramDto);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable long id) {
        instagramService.deleteUserById(id);
        return new ResponseEntity<>("Record is deleted", HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<Instagram>> getAllUsers() {
//        List<Instagram> allUsers = instagramService.getAllUsers();
//        return new ResponseEntity<>(allUsers, HttpStatus.OK);
//    }
    @GetMapping
    public List<InstagramDto> getAllUsers(){
        List<InstagramDto> dtos=instagramService.getAllUsers();
        return dtos;
    }
    @GetMapping("/{id}")
    public ResponseEntity<InstagramDto> getUsersById(@PathVariable long id){
        InstagramDto dto = instagramService.getUsersById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<InstagramDto> updateUsersById(@RequestParam long id, @RequestBody InstagramDto dto) {
        InstagramDto instagramDto = instagramService.updateUsersById(id, dto);
        return new ResponseEntity<>(instagramDto, HttpStatus.OK);
    }

}
