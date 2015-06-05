package com.diary.dao;

import com.diary.domain.MsgGroup;

public interface MsgGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MsgGroup record);

    int insertSelective(MsgGroup record);

    MsgGroup selectByPrimaryKey(Integer id);
    
    Integer getMaxGroupId();

    int updateByPrimaryKeySelective(MsgGroup record);

    int updateByPrimaryKey(MsgGroup record);
}