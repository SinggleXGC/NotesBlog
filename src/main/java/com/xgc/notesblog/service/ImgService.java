package com.xgc.notesblog.service;

import com.xgc.notesblog.Entity.Img;
import com.xgc.notesblog.mapper.ImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgService {

    @Autowired
    ImgMapper imgMapper;

    public int insertImg(Img img) {
        return imgMapper.insertImg(img);
    }
}
