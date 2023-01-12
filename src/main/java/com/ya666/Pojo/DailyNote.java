package com.ya666.Pojo;

import lombok.Data;

@Data
public class DailyNote extends BaseEntity{

    private Integer id;
    private Integer uid;
    private String otDaily;
    private String ptDaily;
    private String stDaily;



}
