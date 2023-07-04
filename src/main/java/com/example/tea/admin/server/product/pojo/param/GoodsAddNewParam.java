package com.example.tea.admin.server.product.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/04 10:48
 */
@Data
@Accessors(chain = true)
public class GoodsAddNewParam implements Serializable {
    /**
     * 详情
     */
    @ApiModelProperty(value = "详情", example = "王八蛋王八蛋黄鹤老板，吃喝嫖赌吃喝嫖赌\n" +
            "\n" +
            "欠下了欠下了3.5亿，带着他的小姨子跑了\n" +
            "\n" +
            "我们没有没有没有办法办法，拿着钱包抵工资工资\n" +
            "\n" +
            "原价都是100多200多300多的钱包，统统20块\n" +
            "\n" +
            "20块20块统统20块，统统统统统统20块\n" +
            "\n" +
            "黄鹤王八蛋王八蛋黄鹤，你不是你不是你不是人\n" +
            "\n" +
            "100多200多300多的钱包，统统20块统统20块\n" +
            "\n" +
            "黄鹤王八蛋王八蛋黄鹤，你不是你不是你不是人\n" +
            "\n" +
            "我们辛辛苦苦干了，辛辛苦苦给你给你干了大半年\n" +
            "\n" +
            "你你你不发不发工资工资，你还我还我血汗钱\n" +
            "\n" +
            "还我血汗钱", position = 1)
    private String detail;
    /**
     * 类别ID
     */
    @ApiModelProperty(value = "类别ID", example = "1", position = 2)
    private Integer categoryId;
    /**
     * 商品条形码
     */
    @ApiModelProperty(value = "商品条形码", example = "562956845", position = 3)
    private String barCode;
    /**
     * 标题
     */
    @ApiModelProperty(value = "标题", example = "江南皮革厂", position = 4)
    private String title;
    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要", example = "浙江温州浙江温州江南皮革厂倒闭了", position = 5)
    private String brief;
    /**
     * 价格
     */
    @ApiModelProperty(value = "价格", example = "9999", position = 6)
    private Long salePrice;
    /**
     * 关键词列表
     */
    @ApiModelProperty(value = "关键词列表", example = "高科技,价格实惠,最新产品", position = 7)
    private String keywords;
    /**
     * 排序序号
     */
    @ApiModelProperty(value = "排序序号", example = "99", position = 8)
    private Integer sort;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态", example = "1", position = 9)
    private Integer status;
}
