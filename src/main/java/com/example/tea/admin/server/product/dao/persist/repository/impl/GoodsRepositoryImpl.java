package com.example.tea.admin.server.product.dao.persist.repository.impl;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.common.util.PageInfoToPageDataConverter;
import com.example.tea.admin.server.product.dao.persist.mapper.GoodsMapper;
import com.example.tea.admin.server.product.dao.persist.repository.IGoodsRepository;
import com.example.tea.admin.server.product.pojo.entity.Goods;
import com.example.tea.admin.server.product.pojo.vo.GoodsListItemVO;
import com.example.tea.admin.server.product.pojo.vo.GoodsStandardVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/04 10:43
 */
@Slf4j
@Repository
public class GoodsRepositoryImpl implements IGoodsRepository {
    @Resource
    private GoodsMapper mapper;
    
    public GoodsRepositoryImpl() {
        log.debug("创建存储库对象: GoodsRepositoryImpl");
    }

    @Override
    public int insert(Goods goods) {
        log.debug("开始执行【上架商品】操作，参数为: {}", goods);
        return mapper.insert(goods);
    }

    @Override
    public int deleteById(Long id) {
        log.debug("开始执行【根据ID删除商品】，参数为: {}", id);
        return mapper.deleteById(id);
    }
    @Override
    public GoodsStandardVO getStandardVO(Long id) {
        log.debug("开始执行【根据ID查询商品详情】，参数为: {}", id);
        return mapper.getStandardVO(id);
    }

    @Override
    public PageData<GoodsListItemVO> listByCategoryId(Long categoryId, Integer pageNum, Integer pageSize) {
        log.debug("开始执行【根据类别ID({})查询商品】操作，页码: {}，每页记录数: {}，", categoryId, pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsListItemVO> list = mapper.listByCategoryId(categoryId);
        
        PageInfo<GoodsListItemVO> pageInfo = new PageInfo<>(list);
        return PageInfoToPageDataConverter.convert(pageInfo);
    }
}
