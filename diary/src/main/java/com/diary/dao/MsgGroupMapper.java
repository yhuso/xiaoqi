package com.diary.dao;

import java.util.List;
import java.util.Map;

import com.diary.domain.MsgGroup;

public interface MsgGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MsgGroup record);

    int insertSelective(MsgGroup record);

    MsgGroup selectByPrimaryKey(Integer id);
    
    Integer getMaxGroupId();
    
    List<MsgGroup> getAllGroup(Map<String,Object> map);

    int updateByPrimaryKeySelective(MsgGroup record);

    int updateByPrimaryKey(MsgGroup record);
}