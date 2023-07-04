package com.example.tea.admin.server.product.dao.persist.repository;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.product.pojo.entity.Goods;
import com.example.tea.admin.server.product.pojo.vo.GoodsListItemVO;
import com.example.tea.admin.server.product.pojo.vo.GoodsStandardVO;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/04 10:43
 */
public interface IGoodsRepository {
    /**
     * 上架商品
     * 
     * @param goods 商品实体类对象
     * @return 受影响的行数
     */
    int insert(Goods goods);

    /**
     * 根据ID删除商品
     * @param id 数据ID
     * @return 受影响的行数
     */
    int deleteById(Long id);

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
    PageData<GoodsListItemVO> listByCategoryId(Long categoryId, Integer pageNum, Integer pageSize);
}
