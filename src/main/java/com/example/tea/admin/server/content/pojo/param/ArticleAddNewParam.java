package com.example.tea.admin.server.content.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/** 
 * 文章新增参数类
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/14 19:18
 */
@Data
public class ArticleAddNewParam implements Serializable {
    /**
     * 类别ID
     */
    private Long categoryId;
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
    @ApiModelProperty(value = "标签列表，实际存入JSON数据", 
            example = "[{\"id\":10, \"name\":\"Spring\"},{\"id\":11, \"name\":\"Spring MVC\"}]")
    private String tags;
    /**
     * 排序序号
     */
    private Integer sort;
    /**
     * 封面图
     */
    @ApiModelProperty(example = "https://img2.baidu.com/it/u=4244269751,4000533845&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500")
    private String coverUrl;
    /**
     * 文章详情
     */
    private String detail;
}
