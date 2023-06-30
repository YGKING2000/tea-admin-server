package com.example.tea.admin.server.content.dao.persist.repository;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.content.pojo.entity.Category;
import com.example.tea.admin.server.content.pojo.vo.CategoryListItemVO;
import com.example.tea.admin.server.content.pojo.vo.CategoryStandardVO;

import java.util.List;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/14 18:26
 */
public interface ICategoryRepository {
    /**
     * 新增分类
     * @param category 新增的分类数据
     * @return 受影响的行数
     */
    int insert(Category category);

    /**
     * 根据ID修改分类
     * @param category 数据ID和修改修改的分类数据
     * @return 受影响的行数
     */
    int updateById(Category category);

    /**
     * 根据名称统计分类数量
     * @param name 分类名称
     * @return 统计数量
     */
    int countByName(String name);

    /**
     * 查询名称相同但ID不同的分类数量
     * @param name 数据名称
     * @param id 数据ID
     * @return 统计数量
     */
    int countByNameAndNotId(String name, Long id);

    /**
     * 根据ID查询分类数据
     * @param id 数据ID
     * @return 分类标准VO类对象
     */
    CategoryStandardVO getStandardById(Long id);

    List<CategoryListItemVO> list();

    PageData<CategoryListItemVO> listByParentId(Long parentId, Integer pageNum, Integer pageSize);

    int deleteById(Long id);

    int countByParentId(Long parentId);
}
