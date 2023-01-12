package com.ya666.Pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Clint extends BaseEntity{

    private Integer uid;
    private String name;
    private Integer gender;
    private Integer age;
    private String birth;
    private String phone;
    private String email;
    private Integer therapyPt;
    private Integer therapySt;
    private Integer therapyOt;
    private String symptom;
    private String dailyNote;
    private Integer isDelete;


}
