package com.xgc.notesblog.dto;

import com.xgc.notesblog.Entity.Essay;
import lombok.Data;

import java.util.Date;

@Data
public class EssayDTO {

    private Integer eid;
    private String title;
    private String content;
    private Integer view;
    private String showPicture;
    private Date createTime;
    private Date updateTime;
    private Boolean isPublish;

    private String username;
    private String avatarUrl;

    private String tagName;

    public EssayDTO(Essay essay) {
        this.eid = essay.getEid();
        this.title = essay.getTitle();
        this.content = essay.getContent();
        this.view = essay.getView();
        this.showPicture = essay.getShowPicture();
        this.createTime = essay.getCreateTime();
        this.updateTime = essay.getUpdateTime();
        this.isPublish = essay.getIsPublish();
    }

}
