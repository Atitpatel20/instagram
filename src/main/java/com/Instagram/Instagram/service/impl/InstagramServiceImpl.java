package com.Instagram.Instagram.service.impl;

import com.Instagram.Instagram.entity.Instagram;
import com.Instagram.Instagram.payload.InstagramDto;
import com.Instagram.Instagram.repository.InstagramRepository;
import com.Instagram.Instagram.service.InstagramService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstagramServiceImpl implements InstagramService {

    InstagramRepository instagramRepository;

    public InstagramServiceImpl(InstagramRepository instagramRepository) {
        this.instagramRepository = instagramRepository;
    }

    @Override
    public InstagramDto createUser(InstagramDto instagramDto) {
        Instagram instagram= new Instagram();
        instagram.setName(instagramDto.getName());
        instagram.setEmail(instagramDto.getEmail());
        instagram.setMessage(instagramDto.getMessage());
        instagram.setMobile(instagramDto.getMobile());

        Instagram saveUsers = instagramRepository.save(instagram);
        InstagramDto dto= new InstagramDto();
        dto.setName(saveUsers.getName());
        dto.setEmail(saveUsers.getEmail());
        dto.setMessage(saveUsers.getMessage());
        dto.setMobile(saveUsers.getMobile());
        return dto;
    }

    @Override
    public void deleteUserById(long id) {
        instagramRepository.deleteById(id);
    }

    @Override
    public List<Instagram> getAllUsers() {
        List<Instagram> users = instagramRepository.findAll();
        return users;
    }

    @Override
    public InstagramDto updateUsersById(long id,InstagramDto dto) {
        Instagram instagram = instagramRepository.findById(id).get();
        instagram.setName(dto.getName());
        instagram.setEmail(dto.getEmail());
        instagram.setMessage(dto.getMessage());
        instagram.setMobile(dto.getMobile());

        Instagram updateUsers = instagramRepository.save(instagram);

        InstagramDto instaDto =new InstagramDto();
        instaDto.setName(updateUsers.getName());
        instaDto.setEmail(updateUsers.getEmail());
        instaDto.setMessage(updateUsers.getMessage());
        instaDto.setMobile(updateUsers.getMobile());
        return instaDto;
    }
}
