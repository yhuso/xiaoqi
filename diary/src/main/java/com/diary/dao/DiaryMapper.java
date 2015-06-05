package com.diary.dao;

import java.util.List;

import com.diary.domain.Diary;

public interface DiaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Diary record);

    int insertSelective(Diary record);

    Diary selectByPrimaryKey(Integer id);

    List<Diary> selectyByGroupId(Integer groupId);
    
    int updateByPrimaryKeySelective(Diary record);

    int updateByPrimaryKey(Diary record);
    
    
}