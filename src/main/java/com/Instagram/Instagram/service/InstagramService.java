package com.Instagram.Instagram.service;

import com.Instagram.Instagram.entity.Instagram;
import com.Instagram.Instagram.payload.InstagramDto;

import java.util.List;

public interface InstagramService {
    InstagramDto createUser(InstagramDto instagramDto );
    void deleteUserById (long id );
    List<Instagram> getAllUsers();
    InstagramDto updateUsersById(long id, InstagramDto dto);
}
