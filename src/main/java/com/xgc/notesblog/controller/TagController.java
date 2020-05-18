package com.xgc.notesblog.controller;

import com.xgc.notesblog.Entity.Tag;
import com.xgc.notesblog.dto.ResponseDTO;
import com.xgc.notesblog.dto.STATUS;
import com.xgc.notesblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/taglist")
    public List<Tag> getTagList() {
        return tagService.getTagList();
    }

    @PostMapping("/addtag")
    public ResponseDTO addTag(@RequestParam String tagName) {
        int status = tagService.insertTag(tagName);
        // status == 1 代表操作成功
        if (status != 1) {
            return new ResponseDTO(STATUS.INTERNAL_SERVER_ERROR.getStatus(),"创建标签失败", null);
        }
        Integer tid = tagService.selectTidByTagName(tagName);
        return new ResponseDTO(STATUS.OK.getStatus(),"新增标签成功", tid);
    }
}