package com.example.tea.admin.server.product.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 商品类别
 */
@Data
@Accessors(chain = true)
@TableName(value = "product_category")
public class Category {
    /**
     * 数据ID
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "数据ID", position = 1)
    private Long id;
    /**
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称", position = 2)
    private String name;
    /**
     * 父级类别ID，如果无父级，则为0
     */
    @ApiModelProperty(value = "父级类别ID，如果无父级，则为0", position = 3)
    private Long parentId;
    /**
     * 深度，最顶级类别的深度为1，次级为2，以此类推
     */
    @ApiModelProperty(value = "深度，最顶级类别的深度为1，次级为2，以此类推", position = 4)
    private Integer depth;
    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    @ApiModelProperty(value = "关键词列表，各关键词使用英文的逗号分隔", position = 5)
    private String keywords;
    /**
     * 排序序号
     */
    @ApiModelProperty(value = "排序序号", position = 6)
    private Integer sort;
    /**
     * 图标图片的URL
     */
    @ApiModelProperty(value = "图标图片的URL", position = 7)
    private String icon;
    /**
     * 是否启用，1=启用，0=未启用
     */
    @ApiModelProperty(value = "是否启用，1=启用，0=未启用", position = 8)
    private Integer enable;
    /**
     * 是否为父级（是否包含子级），1=是父级，0=不是父级
     */
    @ApiModelProperty(value = "是否为父级（是否包含子级），1=是父级，0=不是父级", position = 9)
    private Integer isParent;
    /**
     * 是否显示在导航栏中，1=启用，0=未启用
     */
    @ApiModelProperty(value = "是否显示在导航栏中，1=启用，0=未启用", position = 10)
    private Integer isDisplay;
    /**
     * 数据创建时间
     */
    @ApiModelProperty(value = "数据创建时间", position = 11)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime gmtCreate;
    /**
     * 数据最后修改时间
     */
    @ApiModelProperty(value = "数据最后修改时间", position = 12)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
