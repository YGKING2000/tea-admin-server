package com.example.tea.admin.server.content.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/** 
 * 标签分类修改参数类
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/14 15:36
 */
@Data
public class TagTypeUpdateInfoParam implements Serializable {
    /**
     * 数据ID
     */
    @NotNull(message = "请提交标签ID")
    @Range(min = 1, message = "请提交合法的数据ID值")
    @ApiModelProperty(value = "数据ID", required = true, example = "9")
    private Long id;
    /**
     * 标签名
     */
    @NotNull(message = "请提交标签类别名称")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}$", message = "标签类别名称长度为2~10个字符，且不允许使用标点符号")
    @ApiModelProperty(value = "标签类别名", required = true, example = "茶器标签")
    private String name;
    /**
     * 排序序号
     */
    @NotNull(message = "请提交排序序号")
    @Range(max = 99, message = "排序序号需要在0~99之间")
    @ApiModelProperty(value = "排序序号", required = true, example = "66")
    private Integer sort;
}
