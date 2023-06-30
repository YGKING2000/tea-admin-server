package com.example.tea.admin.server.content.pojo.param;

import lombok.Data;

import java.io.Serializable;

/** 
 * 评论添加参数类
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/14 15:36
 */
@Data
public class CommentAddNewParam implements Serializable {
    /**
     * 作者ID
     */
    private Long authorId;
    /**
     * 作者名字
     */
    private String authorName;
    /**
     * 文章ID
     */
    private Long articleId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * IP
     */
    private String ip;
    /**
     * 楼层
     */
    private Integer floor;
    /**
     * 顶数量
     */
    private Integer upCount;
    /**
     * 踩数量
     */
    private Integer downCount;
    /**
     * 审核状态，0=未审核，1=审核通过，2=拒绝审核
     */
    private Integer checkState;
    /**
     * 审核原因
     */
    private String checkRemarks;
    /**
     * 显示状态，0=不显示，1=显示
     */
    private Integer displayState;
}
