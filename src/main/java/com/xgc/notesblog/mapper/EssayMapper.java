package com.xgc.notesblog.mapper;

import com.xgc.notesblog.Entity.Essay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EssayMapper {

    @Results

    @Insert("insert into essay values (#{eid}, #{title}, #{content},#{view}, #{showPicture}, #{createTime}, #{updateTime}, #{isPublish}, #{tid}, #{uid})")
    int insertEssay(Essay essay);

//    @Select("select * from essay where isPublish = true")
//    List<Essay> selectPublishEssayList();

    @Select("select * from essay where isPublish = true limit #{pageSize} offset #{offset}")
    List<Essay> selectPublishEssayListByQuery(int pageSize, int offset);

    @Select("select count(eid) from essay where isPublish = true")
    int getEssayCount();
}
