package org.example.trpojo.vo;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CardVO {
    private String frontText;
    private String backText;
    private String type;
    private String source;
    private String language;
    private LocalDateTime createdAt;

    private String note;
    private Integer difficulty;
    private Integer reviewCount;
    private Integer WrongCount;
    private LocalDateTime lastReviewTime;
    private LocalDateTime nextReviewTime;
}
