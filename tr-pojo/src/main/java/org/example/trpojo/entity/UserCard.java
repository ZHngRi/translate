package org.example.trpojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserCard {
    private Integer id;
    private Integer userId;
    private Integer cardId;
    private String note;
    private Integer difficulty;
    private Integer reviewCount;
    private Integer WrongCount;
    private LocalDateTime lastReviewTime;
    private LocalDateTime nextReviewTime;
}
