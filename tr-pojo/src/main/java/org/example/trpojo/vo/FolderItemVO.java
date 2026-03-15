package org.example.trpojo.vo;

import lombok.Data;

@Data
public class FolderItemVO {
    private String  name;
    private String createdAt;
    private String ownerName;

    private String overview;
    private Integer total;

}
