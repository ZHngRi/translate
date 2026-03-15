package org.example.trpojo.entity;

import lombok.Data;

@Data
public class Folder {
    private Integer id;
    private Integer userId;
    private String  name;
    private String createdAt;
    private String overview;
}
