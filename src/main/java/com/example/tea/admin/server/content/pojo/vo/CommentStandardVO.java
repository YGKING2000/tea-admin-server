package com.example.tea.admin.server.content.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/** 
 * 评论标准VO类
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @date 2023/06/13 19:56
 */
@Data
public class CommentStandardVO implements Serializable {
    /**
     * 数据ID
     */
    private Long id;
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
     * 引用评论ID
     */
    private String referenceIds;
    /**
     * 显示状态，0=不显示，1=显示
     */
    private Integer displayState;
}
