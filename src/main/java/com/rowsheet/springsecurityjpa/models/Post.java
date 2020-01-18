package com.rowsheet.springsecurityjpa.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String content;
}
