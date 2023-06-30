package com.example.tea.admin.server.content.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 详情实体类
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @date 2023/06/13 20:22
 */
@Data
@Accessors(chain = true)
@TableName("content_article_detail")
public class ArticleDetail implements Serializable {
    /**
     * 数据ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 文章ID
     */
    private Long articleId;
    /**
     * 详情
     */
    private String detail;
    /**
     * 数据创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /**
     * 数据最后修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
