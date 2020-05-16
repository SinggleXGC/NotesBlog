package com.xgc.notesblog.service;

import com.xgc.notesblog.Entity.Tag;
import com.xgc.notesblog.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    TagMapper tagMapper;

    public List<Tag> getTagList() {
        return tagMapper.getTagList();
    }
}
