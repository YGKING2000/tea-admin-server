package com.example.tea.admin.server.product.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/** 商品详情 */
@Data
@Accessors(chain = true)
@TableName(value = "product_goods_detail")
public class GoodsDetail {
    /** 数据ID */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "数据ID", position = 1)
    private Long id;
    /** 详情 */
    @ApiModelProperty(value = "详情", position = 2)
    private String detail;
    /** 数据创建时间 */
    @ApiModelProperty(value = "数据创建时间", position = 3)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /** 数据最后修改时间 */
    @ApiModelProperty(value = "数据最后修改时间", position = 4)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
