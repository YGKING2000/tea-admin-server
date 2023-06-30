package com.example.tea.admin.server.content.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/** 
 * 标签列表项VO类
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @date 2023/06/13 15:31
 */
@Data
public class TagListItemVO implements Serializable {
    /**
     * 数据ID
     */
    private Long id;
    /**
     * 标签名
     */
    private String name;
    /**
     * 父级ID，为0的是标签分类，不为0的是标签
     */
    private Long typeId;
    /**
     * 是否启用，1=启用，0=未启用
     */
    private Integer enable;
    /**
     * 排序序号
     */
    private Integer sort;
    /**
     * 所属类别名称
     */
    private String typeName;
}
