package com.xgc.notesblog.Entity;

import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class User {

    private Integer uid;
    private String username;
    private String password;
    private String avatarUrl;

}
