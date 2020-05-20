package com.xgc.notesblog.mapper;

import com.xgc.notesblog.Entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {

    @Select("select * from tag")
    List<Tag> getTagList();

    @Insert("insert into tag set tagName = #{tagName}")
    int insertTag(String tagName);

    @Select("select tid from tag where tagName = #{tagName}")
    Integer selectTidByTagName(String tagName);

    @Select("select * from tag where tid = #{tid}")
    Tag selectTagByTid(Integer tid);

}
