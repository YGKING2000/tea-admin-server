package com.example.tea.admin.server.dict.dao.persist.mapper;

import com.example.tea.admin.server.dict.pojo.vo.DistrictListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理省市区数据的Mapper接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Repository
public interface DistrictMapper {

    /**
     * 根据父级查询子级地区列表
     *
     * @param parentId 父级地区ID
     * @return 子级地区列表
     */
    List<DistrictListItemVO> listByParentId(Long parentId);

}
