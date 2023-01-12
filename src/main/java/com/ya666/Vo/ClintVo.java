package com.ya666.Vo;

import lombok.Data;

import java.util.Date;

@Data
public class ClintVo {

    private Integer uid;
    private Integer id;
    private String name;
    private Integer gender;
    private Integer age;
    private String otDaily;
    private String ptDaily;
    private String stDaily;
    private String symptom;

    private String createUser;
    private Date createTime;
    private String modifieUser;
    private Date modifieTime;

}
