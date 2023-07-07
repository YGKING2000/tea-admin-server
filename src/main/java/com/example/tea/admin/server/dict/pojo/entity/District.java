package com.example.tea.admin.server.dict.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 省市区实体类
 *
 * @author java@tedu.cn
 * @version 1.0
 **/
@Data
@TableName("dict_district")
public class District implements Serializable {

    /**
     * 数据ID
     */
    @TableId
    private Long id;
    /**
     * 父级单位ID
     */
    private Long parentId;
    /**
     * 行政代号
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 名称后缀
     */
    private String suffix;
    /**
     * 名称拼音
     */
    private String pinyin;
    /**
     * 排序序号
     */
    private Integer sort;

}