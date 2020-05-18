package com.xgc.notesblog.controller;

import com.xgc.notesblog.Entity.Essay;
import com.xgc.notesblog.dto.ResponseDTO;
import com.xgc.notesblog.dto.STATUS;
import com.xgc.notesblog.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EssayController {

    @Autowired
    EssayService essayService;

    @PostMapping("/publish")
    public ResponseDTO publish(@RequestParam String title, @RequestParam String content, @RequestParam Integer tid,
                               @RequestParam String showPicture, @RequestParam Integer uid, @RequestParam Boolean isPublish) {
        Essay essay = new Essay();
        essay.setTitle(title);
        essay.setContent(content);
        essay.setTid(tid);
        essay.setShowPicture(showPicture);
        essay.setUid(uid);
        essay.setIsPublish(isPublish);

        int status = essayService.insertEssay(essay);
        if (status != 1) {
            return new ResponseDTO(STATUS.OK.INTERNAL_SERVER_ERROR.getStatus(), "发布文章失败", null);
        }
        return new ResponseDTO(STATUS.OK.getStatus(), "发布文章成功", null);
    }

}
