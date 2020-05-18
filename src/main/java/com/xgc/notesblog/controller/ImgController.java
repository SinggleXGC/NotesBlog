package com.xgc.notesblog.controller;

import com.xgc.notesblog.Entity.GlobalProperties;
import com.xgc.notesblog.dto.ImgDTO;
import com.xgc.notesblog.dto.ResponseDTO;
import com.xgc.notesblog.dto.STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class ImgController {

    @Autowired
    GlobalProperties globalProperties;

    @PostMapping("/uploadimg")
    public ResponseDTO uploadImg(@RequestParam MultipartFile file) {
        String imgName = file.getOriginalFilename();
        String filepath = "D:/Store/Resource/img";
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

        ImgDTO imgDTO = new ImgDTO(imgName, globalProperties.getBaseurl() + "/img/" + imgName);
        return new ResponseDTO(STATUS.OK.getStatus(), "上传图片成功", imgDTO);
    }
}

