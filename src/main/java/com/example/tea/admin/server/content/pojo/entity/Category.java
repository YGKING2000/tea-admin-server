package com.example.tea.admin.server.content.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/** 
 * 分类实体类
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @date 2023/06/13 17:52
 */
@Data
@Accessors(chain = true)
@TableName("content_category")
public class Category implements Serializable {
    /**
     * 数据ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 类别名称
     */
    private String name;
    /**
     * 父级类别ID，如果无父级，则为0
     */
    private Long parentId;
    /**
     * 深度，最顶级类别的深度为1，次级为2，以此类推
     */
    private Integer depth;
    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    private String keywords;
    /**
     * 排序序号
     */
    private Integer sort;
    /**
     * 图标图片的URL
     */
    private String icon;
    /**
     * 是否启用，1=启用，0=未启用
     */
    private Integer enable;
    /**
     * 是否为父级（是否包含子级），1=是父级，0=不是父级
     */
    private Integer isParent;
    /**
     * 是否显示在导航栏中，1=启用，0=未启用
     */
    private Integer isDisplay;
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
