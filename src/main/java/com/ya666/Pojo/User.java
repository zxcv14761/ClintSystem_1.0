package com.ya666.Pojo;

import lombok.Data;

@Data
public class User extends BaseEntity {

    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private String userType;
    private Integer isDelete;
    private String phone;
    private String email;
    private Integer gender;
}
