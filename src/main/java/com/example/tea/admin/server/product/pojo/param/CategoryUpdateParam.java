package com.example.tea.admin.server.product.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/28 19:42
 */
@Data
public class CategoryUpdateParam implements Serializable {
    /**
     * 类别名称
     */
    @NotNull(message = "修改失败，请提交分类名称!")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,15}$", message = "名称长度为2~15个字符，且不允许使用标点符号")
    @ApiModelProperty(value = "分类名称", required = true, example = "测试标签999")
    private String name;
    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    @NotNull(message = "修改失败，请提交关键词!")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5,]{2,50}$", message = "名关键词列表为2~50个字符")
    @ApiModelProperty(value = "分类名称", required = true, example = "测试标签999")
    private String keywords;
    /**
     * 排序序号
     */
    @NotNull(message = "修改失败，请提交排序序号")
    @Range(max = 99, message = "排序序号需要在0~99之间")
    @ApiModelProperty(value = "排序序号", required = true, example = "3")
    private Integer sort;
    /**
     * 图标图片的URL
     */
    @NotNull(message = "修改失败，请提交图标!")
    @Length(min = 20, max = 200)
    @ApiModelProperty(value = "分类名称", required = true, 
            example = "https://img2.baidu.com/it/u=4244269751,4000533845&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500")
    private String icon;
}
