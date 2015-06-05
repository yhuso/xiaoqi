package com.diary.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Diary {
    private Integer id;

    private String toUserName;

    private String fromUserName;

    private Date createTime;

    private String msgType;

    private String content;

    private Long msgId;

    private Date updateTime;

    private String mediaId;

    private String picUrl;

    private Integer msgGroupId;

}