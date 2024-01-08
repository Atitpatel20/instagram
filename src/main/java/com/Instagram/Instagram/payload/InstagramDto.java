package com.Instagram.Instagram.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstagramDto {
    private long id;

    private String name;
    private String email;
    private String message;
    private long mobile;
}
