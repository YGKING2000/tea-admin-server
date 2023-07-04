package com.example.tea.admin.server.product.dao.persist.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tea.admin.server.product.pojo.entity.Goods;
import com.example.tea.admin.server.product.pojo.vo.GoodsListItemVO;
import com.example.tea.admin.server.product.pojo.vo.GoodsStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/04 10:41
 */
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * 根据ID查询商品详情
     * @param id 数据ID
     * @return 商品标准VO类
     */
    GoodsStandardVO getStandardVO(Long id);
    
    /**
     * 根据类别ID查询商品
     * @param categoryId 类别ID
     * @return 商品列表项VO类的集合
     */
    List<GoodsListItemVO> listByCategoryId(Long categoryId);
}
