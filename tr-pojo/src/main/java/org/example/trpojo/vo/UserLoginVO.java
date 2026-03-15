package org.example.trpojo.vo;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class UserLoginVO {
    private String userName;
    private Long id;
    private LocalDateTime createdAt;
}
