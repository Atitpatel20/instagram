package com.Instagram.Instagram.repository;

import com.Instagram.Instagram.entity.Comment;
import com.Instagram.Instagram.entity.Instagram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comment,Long> {
}
