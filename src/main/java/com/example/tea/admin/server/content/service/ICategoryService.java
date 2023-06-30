package com.example.tea.admin.server.content.service;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.content.pojo.param.CategoryAddNewParam;
import com.example.tea.admin.server.content.pojo.param.CategoryUpdateParam;
import com.example.tea.admin.server.content.pojo.vo.CategoryListItemVO;
import com.example.tea.admin.server.content.pojo.vo.CategoryStandardVO;
import com.example.tea.admin.server.content.pojo.vo.CategoryTreeItemVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/14 14:52
 */
@Transactional
public interface ICategoryService {
    String[] ENABLE_TEXT = {"禁用", "启用"};
    String[] DISPLAY_TEXT = {"隐藏", "显示"};
    
    /**
     * 新增分类
     * @param categoryAddNewParam 新增的分类数据
     */
    void addNew(CategoryAddNewParam categoryAddNewParam);

    /**
     * 根据ID删除分类
     * @param id 数据ID
     */
    void delete(Long id);

    /**
     * 根据ID修改分类
     * @param id 数据ID
     * @param categoryUpdateParam 修改的分类数据
     */
    void update(Long id, CategoryUpdateParam categoryUpdateParam);

    /**
     * 根据ID启用分类
     * @param id 数据ID
     */
    void setEnable(Long id);

    /**
     * 根据ID禁用分类
     * @param id 数据ID
     */
    void setDisable(Long id);

    /**
     * 根据ID显示分类
     * @param id 数据ID
     */
    void setDisplay(Long id);

    /**
     * 根据ID隐藏分类
     * @param id 数据ID
     */
    void setHidden(Long id);

    /**
     * 根据ID查询分类详情
     * @param id 数据ID
     * @return 分类标准VO类
     */
    CategoryStandardVO getStandardById(Long id);

    /**
     * 查询分类树
     * @return 分类树集合
     */
    List<CategoryTreeItemVO> listTree();

    /**
     * 根据父级ID查询子级分类
     * @param parentId 父级ID
     * @param pageNum 页码
     * @return 分类列表项VO类集合
     */
    PageData<CategoryListItemVO> listByParentId(Long parentId, Integer pageNum);

    /**
     * 根据父级ID查询子级分类
     * @param parentId 父级ID
     * @param pageNum 页码
     * @param pageSize 每页记录数               
     * @return 分类列表项VO类集合
     */
    PageData<CategoryListItemVO> listByParentId(Long parentId, Integer pageNum, Integer pageSize);
}
