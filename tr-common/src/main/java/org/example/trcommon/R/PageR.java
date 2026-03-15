package org.example.trcommon.R;

import lombok.Data;

import java.util.List;

@Data
public class PageR<T> {
    private Integer total;
    private List<T> records;
}
