package com.example.tea.admin.server.product.dao.persist.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tea.admin.server.product.pojo.entity.Category;
import com.example.tea.admin.server.product.pojo.vo.CategoryListItemVO;
import com.example.tea.admin.server.product.pojo.vo.CategoryStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 1.0
 * @date 2023/06/13 18:58
 */
@Repository("productCategoryMapper")
public interface CategoryMapper extends BaseMapper<Category> {
    /**
     * 根据ID查询分类数据
     * @param id 数据ID
     * @return 分类标准VO类对象
     */
    CategoryStandardVO getStandardById(Long id);

    /**
     * 查询所有分类
     * @return 分类列表
     */
    List<CategoryListItemVO> list();

    List<CategoryListItemVO> listByParentId(Long parentId);
}
