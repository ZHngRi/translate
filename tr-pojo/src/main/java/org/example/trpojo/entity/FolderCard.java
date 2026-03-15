package org.example.trpojo.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class FolderCard {
    private Integer id;
    private Integer folderId;
    private Integer cardId;
    private LocalDateTime addedAt;
}
