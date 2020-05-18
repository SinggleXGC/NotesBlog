package com.xgc.notesblog.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Essay {

    private Integer eid;
    private String title;
    private String content;
    private String showPicture;
    private Date createTime;
    private Date updateTime;
    private Boolean isPublish;
    private Integer tid;
    private Integer uid;

}
