package com.xgc.notesblog.mapper;

import com.xgc.notesblog.Entity.Essay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EssayMapper {

    @Results

    @Insert("insert into essay values (#{eid}, #{title}, #{content}, #{showPicture}, #{createTime}, #{updateTime}, #{isPublish}, #{tid}, #{uid})")
    int insertEssay(Essay essay);
}
