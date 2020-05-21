package com.xgc.notesblog.service;

import com.xgc.notesblog.Entity.Essay;
import com.xgc.notesblog.Entity.Tag;
import com.xgc.notesblog.Entity.User;
import com.xgc.notesblog.dto.EssayDTO;
import com.xgc.notesblog.dto.ResponseDTO;
import com.xgc.notesblog.dto.STATUS;
import com.xgc.notesblog.mapper.EssayMapper;
import com.xgc.notesblog.mapper.TagMapper;
import com.xgc.notesblog.mapper.UserMapper;
import com.xgc.notesblog.utils.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EssayService {

    @Autowired
    private EssayMapper essayMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TagMapper tagMapper;

    public int insertEssay(Essay essay) {
        essay.setView(0);
        Date date = new Date();
        essay.setCreateTime(date);
        essay.setUpdateTime(date);
        return essayMapper.insertEssay(essay);
    }

//    public List<EssayDTO> selectPublishEssayList(){
//        List<Essay> essays = essayMapper.selectPublishEssayList();
//        List<EssayDTO> essayDTOS = new ArrayList<>();
//        for(Essay essay: essays) {
//            EssayDTO essayDTO = new EssayDTO(essay);
//            Integer uid = essay.getUid();
//            User user = userMapper.selectUserByUid(uid);
//            essayDTO.setUsername(user.getUsername());
//            essayDTO.setAvatarUrl(user.getAvatarUrl());
//
//            Tag tag = tagMapper.selectTagByTid(essay.getTid());
//            essayDTO.setTagName(tag.getTagName());
//            essayDTOS.add(essayDTO);
//        }
//        return essayDTOS;
//    }

    public List<EssayDTO> selectPublishEssayListByQuery(int pageNum, int pageSize, int tid) {
        int offset = (pageNum - 1) * pageSize;
        List<Essay> essays;
        if (tid == -1) {
            essays = essayMapper.selectPublishEssayListByPageSizeAndOffset(pageSize, offset);
        }else {
            essays = essayMapper.selectPublishEssayListByPageSizeAndOffsetAndTid(pageSize, offset, tid);
        }
        List<EssayDTO> essayDTOS = new ArrayList<>();
        for(Essay essay: essays) {
            EssayDTO essayDTO = new EssayDTO(essay);
            Integer uid = essay.getUid();
            User user = userMapper.selectUserByUid(uid);
            essayDTO.setUsername(user.getUsername());
            essayDTO.setAvatarUrl(user.getAvatarUrl());

            Tag tag = tagMapper.selectTagByTid(essay.getTid());
            essayDTO.setTagName(tag.getTagName());
            essayDTOS.add(essayDTO);
        }
        return essayDTOS;
    }

    public int getEssayCount() {
        return essayMapper.getEssayCount();
    }

    public int getEssayByTidCount(int tid) {
        return essayMapper.getEssayByTidCount(tid);
    }

    public Essay getEssayByEid(int eid) {
        Essay essay = essayMapper.getEssayByEid(eid);
        String content = essay.getContent();
        essay.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return essay;
    }
}
