package com.example.tea.admin.server.dict.dao.persist.repository.impl;

import com.example.tea.admin.server.dict.dao.persist.mapper.DistrictMapper;
import com.example.tea.admin.server.dict.dao.persist.repository.IDistrictRepository;
import com.example.tea.admin.server.dict.pojo.vo.DistrictListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理省市区数据的数据访问实现类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@Repository
public class DisctrictRepositoryImpl implements IDistrictRepository {

    @Resource
    private DistrictMapper districtMapper;

    public DisctrictRepositoryImpl() {
        log.debug("创建存储库对象：DisctrictRepositoryImpl");
    }

    @Override
    public List<DistrictListItemVO> listByParentId(Long parentId) {
        log.debug("开始执行【根据父级查询子级地区列表】的数据访问，参数：{}", parentId);
        return districtMapper.listByParentId(parentId);
    }

}
