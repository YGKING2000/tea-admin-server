package com.example.tea.admin.server.dict.dao.persist.repository;

import com.example.tea.admin.server.dict.pojo.vo.DistrictListItemVO;

import java.util.List;

/**
 * 处理省市区数据的数据访问接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
public interface IDistrictRepository {

    /**
     * 根据父级查询子级地区列表
     *
     * @param parentId 父级地区ID
     * @return 子级地区列表
     */
    List<DistrictListItemVO> listByParentId(Long parentId);

}