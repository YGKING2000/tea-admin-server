package com.example.tea.admin.server.dict.service.impl;

import com.example.tea.admin.server.dict.dao.persist.repository.IDistrictRepository;
import com.example.tea.admin.server.dict.pojo.vo.DistrictListItemVO;
import com.example.tea.admin.server.dict.service.IDistrictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理省市区数据的业务实现类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@Service
public class DistrictServiceImpl implements IDistrictService {

    @Resource
    private IDistrictRepository districtRepository;

    public DistrictServiceImpl() {
        log.debug("创建业务类对象：DistrictServiceImpl");
    }

    @Override
    public List<DistrictListItemVO> listByParentId(Long parentId) {
        log.debug("开始执行【根据父级查询子级地区列表】的业务，参数：{}", parentId);
        return districtRepository.listByParentId(parentId);
    }

}