package com.example.tea.admin.server.content.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/** 
 * 顶踩历史列表项VO类
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @date 2023/06/13 20:54
 */
@Data
public class UpDownLogListItemVO implements Serializable {
    /**
     * 数据ID
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 资源类型，0=文章，1=评论
     */
    private Integer resourceType;
    /**
     * 资源ID
     */
    private Long resourceId;
    /**
     * 操作类型，0=踩，1=顶
     */
    private Integer opType;
}
