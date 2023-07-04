package com.example.tea.admin.server.product.service;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.product.pojo.param.GoodsAddNewParam;
import com.example.tea.admin.server.product.pojo.vo.GoodsListItemVO;
import com.example.tea.admin.server.product.pojo.vo.GoodsStandardVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/04 10:45
 */
@Transactional
public interface IGoodsService {
    /**
     * 上架商品
     * @param goodsAddNewParam 客户端提交的参数
     */
    void addNew(GoodsAddNewParam goodsAddNewParam);

    /**
     * 根据ID删除商品
     * @param id 数据ID
     */
    void deleteById(Long id);

    /**
     * 根据ID查询商品详情
     * @param id 数据ID
     * @return 商品标准VO类
     */
    GoodsStandardVO getStandardVO(Long id);

    /**
     * 根据分类ID分页查询商品数据
     * @param categoryId 分类ID
     * @param pageNum　页码
     * @param pageSize　每页记录数
     * @return 商品数据
     */
    PageData<GoodsListItemVO> listByCategory(Long categoryId, Integer pageNum, Integer pageSize);
}
