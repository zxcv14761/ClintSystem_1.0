package com.ya666.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {
    private String createUser;
    private Date createTime;
    private String modifieUser;
    private Date modifieTime;
}
