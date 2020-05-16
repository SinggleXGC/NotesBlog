package com.xgc.notesblog.controller;

import com.xgc.notesblog.Entity.Img;
import com.xgc.notesblog.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class ImgController {

    @Autowired
    ImgService imgService;

    @PostMapping("/uploadimg")

    public String uploadImg(@RequestParam MultipartFile file) {
        String imgName = file.getOriginalFilename();
        String classpath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        String filepath = classpath + "static" + File.separator + "img";
        File f = new File(filepath);
        if (!f.exists()) {
            f.mkdirs();
        }
        File imgFile = new File(filepath + File.separator + imgName);
        try {
            file.transferTo(imgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Img img = new Img();
        img.setImgName(imgName);
        img.setImgUrl("/static/img/" + imgName);
        imgService.insertImg(img);

        return "nothing";
    }
}

