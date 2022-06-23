package com.example.vblogservice.mapper;

import com.example.vblogservice.entity.domian.LikeExample;
import com.example.vblogservice.entity.domian.LikeKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LikeMapper {
    long countByExample(LikeExample example);

    int deleteByExample(LikeExample example);

    int deleteByPrimaryKey(LikeKey key);

    int insert(LikeKey record);

    int insertSelective(LikeKey record);

    List<LikeKey> selectByExample(LikeExample example);

    int updateByExampleSelective(@Param("record") LikeKey record, @Param("example") LikeExample example);

    int updateByExample(@Param("record") LikeKey record, @Param("example") LikeExample example);
}
