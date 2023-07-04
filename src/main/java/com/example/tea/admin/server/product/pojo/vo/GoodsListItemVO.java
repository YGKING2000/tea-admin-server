package com.example.tea.admin.server.product.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/04 11:40
 */
@Data
public class GoodsListItemVO implements Serializable {
    /**
     * 数据ID
     */
    @ApiModelProperty(value = "数据ID", position = 1)
    private Long id;
    /**
     * 类别ID
     */
    @ApiModelProperty(value = "类别ID", position = 2)
    private Integer categoryId;
    /**
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称", position = 3)
    private String categoryName;
    /**
     * 商品条形码
     */
    @ApiModelProperty(value = "商品条形码", position = 4)
    private String barCode;
    /**
     * 标题
     */
    @ApiModelProperty(value = "标题", position = 5)
    private String title;
    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要", position = 6)
    private String brief;
    /**
     * 价格
     */
    @ApiModelProperty(value = "价格", position = 7)
    private Long salePrice;
    /**
     * 关键词列表
     */
    @ApiModelProperty(value = "关键词列表", position = 8)
    private String keywords;
    /**
     * 排序序号
     */
    @ApiModelProperty(value = "排序序号", position = 9)
    private Integer sort;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态", position = 10)
    private Integer status;
}
