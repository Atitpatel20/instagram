package com.Instagram.Instagram.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "test")
@AllArgsConstructor
@NoArgsConstructor
public class Instagram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @Column(name = "email", unique = true)
    private String email;
    private String message;
    @Column(name = "mobile", unique = true)
    private long mobile;

    @OneToMany(mappedBy = "instagram", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
