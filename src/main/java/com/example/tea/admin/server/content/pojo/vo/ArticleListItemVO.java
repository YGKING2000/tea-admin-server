package com.example.tea.admin.server.content.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/** 
 * 文章列表项VO类
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @date 2023/06/13 19:28
 */
@Data
public class ArticleListItemVO implements Serializable {
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
     * 类别ID
     */
    private Long categoryId;
    /**
     * 所属分类名称
     */
    private String categoryName;
    /**
     * 标题
     */
    private String title;
    /**
     * 摘要
     */
    private String brief;
    /**
     * 标签列表，实际存入JSON数据
     */
    private String tags;
    /**
     * IP
     */
    private String ip;
    /**
     * 排序序号
     */
    private Integer sort;
    /**
     * 封面图
     */
    private String coverUrl;
    /**
     * 顶数量
     */
    private Integer upCount;
    /**
     * 踩数量
     */
    private Integer downCount;
    /**
     * 浏览量
     */
    private Integer clickCount;
    /**
     * 评论量
     */
    private Integer commentCount;
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
