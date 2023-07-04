package com.example.tea.admin.server.product.service.impl;

import com.example.tea.admin.server.common.exception.ServiceException;
import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.common.web.ServiceCode;
import com.example.tea.admin.server.product.dao.persist.repository.ICategoryRepository;
import com.example.tea.admin.server.product.dao.persist.repository.IGoodsDetailRepository;
import com.example.tea.admin.server.product.dao.persist.repository.IGoodsRepository;
import com.example.tea.admin.server.product.pojo.entity.Goods;
import com.example.tea.admin.server.product.pojo.entity.GoodsDetail;
import com.example.tea.admin.server.product.pojo.param.GoodsAddNewParam;
import com.example.tea.admin.server.product.pojo.vo.CategoryStandardVO;
import com.example.tea.admin.server.product.pojo.vo.GoodsListItemVO;
import com.example.tea.admin.server.product.pojo.vo.GoodsStandardVO;
import com.example.tea.admin.server.product.service.IGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/04 10:45
 */
@Slf4j
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Resource
    private IGoodsRepository goodsRepository;
    
    @Resource
    private IGoodsDetailRepository detailRepository;
    
    @Resource
    private ICategoryRepository categoryRepository;

    public GoodsServiceImpl() {
        log.debug("创建业务对象: GoodsServiceImpl");
    }

    @Override
    public void addNew(GoodsAddNewParam goodsAddNewParam) {
        log.debug("开始处理【上架商品】业务，参数为: {}", goodsAddNewParam);
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsAddNewParam, goods);
        int rows = goodsRepository.insert(goods);
        if (rows != 1) {
            String message = "上架商品失败，服务器忙，请稍后重试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UNKNOWN, message);
        }

        GoodsDetail goodsDetail = new GoodsDetail();
        goodsDetail.setDetail(goodsAddNewParam.getDetail());
        rows = detailRepository.insert(goodsDetail);
        if (rows != 1) {
            String message = "上架商品失败，服务器忙，请稍后重试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UNKNOWN, message);
        }
    }

    @Override
    public void deleteById(Long id) {
        log.debug("开始处理【根据ID删除商品】业务，参数为: {}", id);
        GoodsStandardVO standardVO = goodsRepository.getStandardVO(id);
        if (standardVO == null) {
            String message = "删除商品失败，该商品不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        
        int rows = goodsRepository.deleteById(id);
        if (rows != 1) {
            String message = "删除商品失败，服务器忙，请稍后重试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UNKNOWN, message);
        }
    }

    @Override
    public PageData<GoodsListItemVO> listByCategory(Long categoryId, Integer pageNum, Integer pageSize) {
        log.debug("开始处理【根据类别ID({})查询商品】业务，页码: {}，每页记录数: {}，", categoryId, pageNum, pageSize);
        CategoryStandardVO categoryStandardVO = categoryRepository.getStandardById(categoryId);
        if (categoryStandardVO == null) {
            String message = "查询商品失败，该类别不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        return goodsRepository.listByCategoryId(categoryId, pageNum, pageSize);
    }

    @Override
    public GoodsStandardVO getStandardVO(Long id) {
        log.debug("开始处理【根据ID查询商品详情】业务，参数为: {}", id);
        GoodsStandardVO standardVO = goodsRepository.getStandardVO(id);
        if (standardVO == null) {
            String message = "查询商品详情失败，该商品不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        return standardVO;
    }
}
