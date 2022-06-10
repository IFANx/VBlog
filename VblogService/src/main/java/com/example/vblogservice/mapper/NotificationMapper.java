package com.example.vblogservice.mapper;

import com.example.vblogservice.entity.domian.Notification;
import com.example.vblogservice.entity.domian.NotificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotificationMapper {
    long countByExample(NotificationExample example);

    int deleteByExample(NotificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Notification record);

    int insertSelective(Notification record);

    List<Notification> selectByExampleWithBLOBs(NotificationExample example);

    List<Notification> selectByExample(NotificationExample example);

    Notification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Notification record, @Param("example") NotificationExample example);

    int updateByExampleWithBLOBs(@Param("record") Notification record, @Param("example") NotificationExample example);

    int updateByExample(@Param("record") Notification record, @Param("example") NotificationExample example);

    int updateByPrimaryKeySelective(Notification record);

    int updateByPrimaryKeyWithBLOBs(Notification record);

    int updateByPrimaryKey(Notification record);
}