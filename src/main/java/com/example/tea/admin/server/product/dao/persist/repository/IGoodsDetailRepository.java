package com.example.tea.admin.server.product.dao.persist.repository;

import com.example.tea.admin.server.product.pojo.entity.GoodsDetail;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/04 11:16
 */
public interface IGoodsDetailRepository {
    /**
     * 添加商品详情
     *
     * @param goodsDetail 商品详情实体类对象
     * @return 受影响的行数
     */
    int insert(GoodsDetail goodsDetail);
}
