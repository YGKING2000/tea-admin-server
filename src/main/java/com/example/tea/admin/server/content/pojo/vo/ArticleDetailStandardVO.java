package com.example.tea.admin.server.content.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/** 
 * 详情标准VO类
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @date 2023/06/13 20:22
 */
@Data
public class ArticleDetailStandardVO implements Serializable {
    /**
     * 数据ID
     */
    private Long id;
    /**
     * 文章ID
     */
    private Long articleId;
    /**
     * 详情
     */
    private String detail;
}
