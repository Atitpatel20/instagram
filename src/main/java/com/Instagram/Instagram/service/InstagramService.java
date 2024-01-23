package com.Instagram.Instagram.service;

import com.Instagram.Instagram.payload.InstagramDto;

import java.util.List;

public interface InstagramService {
    InstagramDto createUser(InstagramDto instagramDto );
    void deleteUserById (long id );
   // List<Instagram> getAllUsers();
    InstagramDto updateUsersById(long id, InstagramDto dto);

    InstagramDto getUsersById(long id);

    List<InstagramDto> getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);
}
