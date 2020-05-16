package com.xgc.notesblog.mapper;

import com.xgc.notesblog.Entity.Img;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ImgMapper {

    @Results(id = "img", value = {
            @Result(column = "iid", property = "iid", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "imgName", property = "imgName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "imgUrl", property = "imgUrl", jdbcType = JdbcType.VARCHAR)
    })

    @Insert("insert into Img values (#{iid}, #{imgName}, #{imgUrl})")
    int insertImg(Img img);

    @Select("select * from Img where iid = #{iid}")
    int selectImgById(int iid);
}
