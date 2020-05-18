package com.xgc.notesblog.service;

import com.xgc.notesblog.Entity.Essay;
import com.xgc.notesblog.mapper.EssayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EssayService {

    @Autowired
    private EssayMapper essayMapper;

    public int insertEssay(Essay essay) {
        Date date = new Date();
        essay.setCreateTime(date);
        essay.setUpdateTime(date);
        return essayMapper.insertEssay(essay);
    }
}
