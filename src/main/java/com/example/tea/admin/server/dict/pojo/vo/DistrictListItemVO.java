package com.example.tea.admin.server.dict.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 省市区VO类
 *
 * @author java@tedu.cn
 * @version 1.0
 **/
@Data
public class DistrictListItemVO implements Serializable {

    /**
     * 数据ID
     */
    private Long id;
    /**
     * 行政代号
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 名称拼音
     */
    private String pinyin;

}