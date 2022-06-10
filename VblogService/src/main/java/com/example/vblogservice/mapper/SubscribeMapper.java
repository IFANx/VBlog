package com.example.vblogservice.mapper;

import com.example.vblogservice.entity.domian.SubscribeExample;
import com.example.vblogservice.entity.domian.SubscribeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubscribeMapper {
    long countByExample(SubscribeExample example);

    int deleteByExample(SubscribeExample example);

    int deleteByPrimaryKey(SubscribeKey key);

    int insert(SubscribeKey record);

    int insertSelective(SubscribeKey record);

    List<SubscribeKey> selectByExample(SubscribeExample example);

    int updateByExampleSelective(@Param("record") SubscribeKey record, @Param("example") SubscribeExample example);

    int updateByExample(@Param("record") SubscribeKey record, @Param("example") SubscribeExample example);
}