package org.example.trpojo.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Card {
    private Integer id;
    private String frontText;
    private String backText;
    private String type;
    private String source;
    private String language;
    private LocalDateTime createdAt;
}
