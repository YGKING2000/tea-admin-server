package com.example.tea.admin.server.product.dao.persist.repository.impl;

import com.example.tea.admin.server.product.dao.persist.mapper.GoodsDetailMapper;
import com.example.tea.admin.server.product.dao.persist.repository.IGoodsDetailRepository;
import com.example.tea.admin.server.product.pojo.entity.GoodsDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/04 11:17
 */
@Slf4j
@Repository
public class GoodsDetailRepositoryImpl implements IGoodsDetailRepository {
    @Resource
    private GoodsDetailMapper mapper;
    
    public GoodsDetailRepositoryImpl() {
        log.debug("创建存储库对象: GoodsDetailRepositoryImpl");
    }
    
    @Override
    public int insert(GoodsDetail goodsDetail) {
        log.debug("开始执行【添加商品详情】操作，参数为: {}", goodsDetail);
        return mapper.insert(goodsDetail);
    }
}
