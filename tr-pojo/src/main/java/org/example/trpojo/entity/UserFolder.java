package org.example.trpojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserFolder {
    private Integer id;
    private Integer folderId;
    private Integer userId;
    private LocalDateTime addedAt;
}
