package com.Instagram.Instagram.service.impl;

import com.Instagram.Instagram.entity.Instagram;
import com.Instagram.Instagram.exception.ResourceNotFoundException;
import com.Instagram.Instagram.payload.InstagramDto;
import com.Instagram.Instagram.repository.InstagramRepository;
import com.Instagram.Instagram.service.InstagramService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstagramServiceImpl implements InstagramService {

    InstagramRepository instagramRepository;

    public InstagramServiceImpl(InstagramRepository instagramRepository) {
        this.instagramRepository = instagramRepository;
    }

    @Override
    public InstagramDto createUser(InstagramDto instagramDto) {
        Instagram instagram = mapToEntity(instagramDto);

        Instagram saveUsers = instagramRepository.save(instagram);
        InstagramDto dto = mapToDto(saveUsers);
        return dto;
    }

    @Override
    public void deleteUserById(long id) {
        instagramRepository.deleteById(id);
    }

//    @Override
//    public List<Instagram> getAllUsers() {
//        List<Instagram> users = instagramRepository.findAll();
//        return users;
//    }

    @Override
    public InstagramDto updateUsersById(long id,InstagramDto dto) {
        Instagram instagram = instagramRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User not found with this id: "+id)
        );
        instagram.setName(dto.getName());
        instagram.setEmail(dto.getEmail());
        instagram.setMessage(dto.getMessage());
        instagram.setMobile(dto.getMobile());

        Instagram updateUsers = instagramRepository.save(instagram);

        InstagramDto instaDto = mapToDto(updateUsers);
        return instaDto;
    }

    @Override
    public InstagramDto getUsersById(long id) {
        Instagram instagram = instagramRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("user not found with this id:" + id)
        );
        InstagramDto dto= mapToDto(instagram);
        return dto;
    }

    @Override
    public List<InstagramDto> getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable=PageRequest.of(pageNo,pageSize,sort);
        Page<Instagram> pageUsers = instagramRepository.findAll(pageable);
        List<Instagram> users = pageUsers.getContent();
        List<InstagramDto> dtos = users.stream().map(i -> mapToDto(i)).collect(Collectors.toList());
        return dtos;
    }
    InstagramDto mapToDto(Instagram instagram){
        InstagramDto dto = new InstagramDto();
        dto.setId(instagram.getId());
        dto.setName(instagram.getName());
        dto.setEmail(instagram.getEmail());
        dto.setMobile(instagram.getMobile());
        dto.setMessage(instagram.getMessage());
        return dto;
    }
   Instagram mapToEntity(InstagramDto instagramDto){
       Instagram instagram= new Instagram();
       instagram.setId(instagramDto.getId());
       instagram.setName(instagramDto.getName());
       instagram.setEmail(instagramDto.getEmail());
       instagram.setMobile(instagramDto.getMobile());
       instagram.setMessage(instagramDto.getMessage());
        return instagram;
    }
    
    
}
