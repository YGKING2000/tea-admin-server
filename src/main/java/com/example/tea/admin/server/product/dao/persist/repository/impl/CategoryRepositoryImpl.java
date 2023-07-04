package com.example.tea.admin.server.product.dao.persist.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.common.util.PageInfoToPageDataConverter;
import com.example.tea.admin.server.product.dao.persist.mapper.CategoryMapper;
import com.example.tea.admin.server.product.dao.persist.repository.ICategoryRepository;
import com.example.tea.admin.server.product.pojo.entity.Category;
import com.example.tea.admin.server.product.pojo.vo.CategoryListItemVO;
import com.example.tea.admin.server.product.pojo.vo.CategoryStandardVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/04 14:14
 */
@Slf4j
@Repository("productCategoryRepository")
public class CategoryRepositoryImpl implements ICategoryRepository {
    @Resource
    private CategoryMapper mapper;

    public CategoryRepositoryImpl() {
        log.info("创建存储库对象: CategoryRepositoryImpl");
    }

    @Override
    public int insert(Category category) {
        log.debug("开始执行【内容-分类】中插入数据: {}", category);
        return mapper.insert(category);
    }

    @Override
    public int deleteById(Long id) {
        log.debug("开始执行【根据ID({})删除分类】", id);
        return mapper.deleteById(id);
    }

    @Override
    public int updateById(Category category) {
        log.debug("开始执行【根据名称ID修改】分类，参数为: {}", category);
        return mapper.updateById(category);
    }

    @Override
    public int countByName(String name) {
        log.debug("开始执行【根据名称({})统计记录数】", name);
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return mapper.selectCount(wrapper);
    }

    @Override
    public int countByNameAndNotId(String name, Long id) {
        log.debug("开始执行【根据名称({})以及ID不等于({})统计记录数】", name, id);
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        wrapper.ne("id", id);
        return mapper.selectCount(wrapper);
    }

    @Override
    public int countByParentId(Long parentId) {
        log.debug("开始执行【根据parentId({})统计记录数】", parentId);
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", parentId);
        return mapper.selectCount(wrapper);
    }

    @Override
    public CategoryStandardVO getStandardById(Long id) {
        log.debug("开始执行【根据名称ID查询】分类详情，参数为: {}", id);
        return mapper.getStandardById(id);
    }

    @Override
    public List<CategoryListItemVO> list() {
        log.debug("开始执行【查询所有分类】列表");
        return mapper.list();
    }

    @Override
    public PageData<CategoryListItemVO> listByParentId(Long parentId, Integer pageNum, Integer pageSize) {
        log.debug("开始执行【查询类别列表】的数据访问，父级ID: {}，页码: {}，每页记录数: {}", parentId, pageNum, pageSize);

        PageHelper.startPage(pageNum, pageSize);
        List<CategoryListItemVO> list = mapper.listByParentId(parentId);

        PageInfo<CategoryListItemVO> pageInfo = new PageInfo<>(list);
        return PageInfoToPageDataConverter.convert(pageInfo);
    }
}
