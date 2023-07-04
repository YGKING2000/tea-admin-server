package com.example.tea.admin.server.product.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/** 商品 */
@Data
@Accessors(chain = true)
@TableName(value = "product_goods")
public class Goods {
    /** 数据ID */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "数据ID", position = 1)
    private Long id;
    /** 类别ID */
    @ApiModelProperty(value = "类别ID", position = 2)
    private Integer categoryId;
    /** 商品条形码 */
    @ApiModelProperty(value = "商品条形码", position = 3)
    private String barCode;
    /** 标题 */
    @ApiModelProperty(value = "标题", position = 4)
    private String title;
    /** 摘要 */
    @ApiModelProperty(value = "摘要", position = 5)
    private String brief;
    /** 价格 */
    @ApiModelProperty(value = "价格", position = 6)
    private Long salePrice;
    /** 关键词列表 */
    @ApiModelProperty(value = "关键词列表", position = 7)
    private String keywords;
    /** 排序序号 */
    @ApiModelProperty(value = "排序序号", position = 8)
    private Integer sort;
    /** 状态 */
    @ApiModelProperty(value = "状态", position = 9)
    private Integer status;
    /** 数据创建时间 */
    @ApiModelProperty(value = "数据创建时间", position = 10)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /** 数据最后修改时间 */
    @ApiModelProperty(value = "数据最后修改时间", position = 11)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
