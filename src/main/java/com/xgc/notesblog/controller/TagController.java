package com.xgc.notesblog.controller;

import com.xgc.notesblog.Entity.Tag;
import com.xgc.notesblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


}
