package com.example.tea.admin.server.content.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/** 
 * 标签添加参数类
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/14 15:36
 */
@Data
public class TagAddNewParam implements Serializable {
    /**
     * 标签名
     */
    @NotNull(message = "请提交标签名称")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}$", message = "标签名称长度为2~10个字符，且不允许使用标点符号")
    @ApiModelProperty(value = "标签名", required = true, example = "茶具标签")
    private String name;
    /**
     * 是否启用，1=启用，0=未启用
     */
    @NotNull(message = "请提交是否启用值")
    @Range(max = 1, message = "是否启用的值只能为0或1")
    @ApiModelProperty(value = "是否启用，1=启用，0=未启用", required = true, example = "1")
    private Integer enable;
    /**
     * 排序序号
     */
    @NotNull(message = "请提交排序序号")
    @Range(max = 99, message = "排序序号需要在0~99之间")
    @ApiModelProperty(value = "排序序号", required = true, example = "3")
    private Integer sort;
    /**
     * 父级ID，为0的是标签类别，不为0的是标签
     */
    @NotNull(message = "请提交父级ID")
    @Range(max = Integer.MAX_VALUE, message = "父级ID的值只能为0或其他值")
    @ApiModelProperty(value = "父级ID，为0的是标签类别，不为0的是标签", required = true, example = "0")
    private Long parentId;
}
