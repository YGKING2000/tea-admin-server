package com.example.tea.admin.server.product.service.impl;

import com.example.tea.admin.server.common.exception.ServiceException;
import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.common.web.ServiceCode;
import com.example.tea.admin.server.product.dao.persist.repository.ICategoryRepository;
import com.example.tea.admin.server.product.pojo.entity.Category;
import com.example.tea.admin.server.product.pojo.param.CategoryAddNewParam;
import com.example.tea.admin.server.product.pojo.param.CategoryUpdateParam;
import com.example.tea.admin.server.product.pojo.vo.CategoryListItemVO;
import com.example.tea.admin.server.product.pojo.vo.CategoryStandardVO;
import com.example.tea.admin.server.product.pojo.vo.CategoryTreeItemVO;
import com.example.tea.admin.server.product.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/04 14:18
 */
@Slf4j
@Service("productCategoryService")
public class CategoryServiceImpl implements ICategoryService {
    @Resource
    private ICategoryRepository repository;

    @Value("${tea-store.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;

    public CategoryServiceImpl() {
        log.info("创建业务对象: CategoryServiceImpl");
    }

    @Override
    public void addNew(CategoryAddNewParam param) {
        log.debug("开始处理【新增分类】业务，参数: {}", param);

        String name = param.getName();
        int rows = repository.countByName(name);
        if (rows != 0) {
            String message = "新增类别失败，该类别名称已被占用!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Long parentId = param.getParentId();
        int depth = 1;
        CategoryStandardVO parentCategory = null;
        if (parentId != 0) {
            parentCategory = repository.getStandardById(parentId);
            if (parentCategory == null) {
                String message = "新增类别失败，父级类别不存在!";
                log.warn(message);
                throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
            } else {
                depth = parentCategory.getDepth() + 1;
            }
        }

        Category category = new Category();
        BeanUtils.copyProperties(param, category);
        category.setDepth(depth);
        category.setIsParent(0);
        rows = repository.insert(category);
        if (rows != 1) {
            String message = "新增类别失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_INSERT, message);
        }

        if (parentId != 0 && parentCategory.getIsParent() == 0) {
            Category updateParentCategory = new Category();
            updateParentCategory.setId(parentId);
            updateParentCategory.setIsParent(1);
            rows = repository.updateById(updateParentCategory);
            if (rows != 1) {
                String message = "修改类别失败，服务器忙，请稍后再尝试!";
                log.warn(message);
                throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
            }
        }
    }

    @Override
    public void delete(Long id) {
        log.debug("开始处理【根据ID删除分类】业务，参数为: {}", id);

        CategoryStandardVO categoryStandardVO = repository.getStandardById(id);
        if (categoryStandardVO == null) {
            String message = "删除类别失败，尝试删除的分类不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        if (categoryStandardVO.getIsParent() == 1) {
            String message = "删除类别失败，尝试删除的分类还有子分类存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        int rows = repository.deleteById(id);
        if (rows != 1) {
            String message = "删除类别失败，服务器忙，请稍后再尝试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_DELETE, message);
        }

        Long parentId = categoryStandardVO.getParentId();
        int count = repository.countByParentId(parentId);
        if (count == 0) {
            Category parentCategory = new Category();
            parentCategory.setId(parentId);
            parentCategory.setIsParent(0);
            rows = repository.updateById(parentCategory);
            if (rows != 1) {
                String message = "修改类别失败，服务器忙，请稍后再尝试!";
                log.warn(message);
                throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
            }
        }
    }

    @Override
    public void update(Long id, CategoryUpdateParam categoryUpdateParam) {
        log.debug("开始处理【根据ID({})修改分类】业务，参数为: {}", id, categoryUpdateParam);

        CategoryStandardVO categoryStandardVO = repository.getStandardById(id);
        if (categoryStandardVO == null) {
            String message = "修改类别失败，尝试修改的分类不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        int count = repository.countByNameAndNotId(categoryUpdateParam.getName(), id);
        if (count != 0) {
            String message = "修改类别失败，尝试修改的分类名称已经存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Category category = new Category();
        BeanUtils.copyProperties(categoryUpdateParam, category);
        category.setId(id);
        int rows = repository.updateById(category);
        if (rows != 1) {
            String message = "修改类别失败，服务器忙，请稍后再尝试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }

    @Override
    public void setEnable(Long id) {
        log.debug("开始处理【根据ID({})启用分类】业务", id);
        updateEnableById(id, 1);
    }

    @Override
    public void setDisable(Long id) {
        log.debug("开始处理【根据ID({})禁用分类】业务", id);
        updateEnableById(id, 0);
    }

    private void updateEnableById(Long id, Integer enable) {
        CategoryStandardVO categoryStandardVO = repository.getStandardById(id);
        if (categoryStandardVO == null) {
            String message = ENABLE_TEXT[enable] + "类别失败，尝试" + ENABLE_TEXT[enable] +"的分类不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        if (enable.equals(categoryStandardVO.getEnable())) {
            String message = ENABLE_TEXT[enable] + "类别失败，尝试" + ENABLE_TEXT[enable] +"的分类已处于此状态!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Category category = new Category();
        category.setId(id).setEnable(enable);
        int rows = repository.updateById(category);
        if (rows != 1) {
            String message = ENABLE_TEXT[enable] + "类别失败，服务器忙，请稍后重试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }

    @Override
    public void setDisplay(Long id) {
        log.debug("开始处理【根据ID({})显示分类】业务", id);
        updateDisplayById(id, 1);
    }

    @Override
    public void setHidden(Long id) {
        log.debug("开始处理【根据ID({})隐藏分类】业务", id);
        updateDisplayById(id, 0);
    }

    private void updateDisplayById(Long id, Integer isDisplay) {
        CategoryStandardVO categoryStandardVO = repository.getStandardById(id);
        if (categoryStandardVO == null) {
            String message = DISPLAY_TEXT[isDisplay] + "类别失败，尝试" + DISPLAY_TEXT[isDisplay] +"的分类不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        if (isDisplay.equals(categoryStandardVO.getIsDisplay())) {
            String message = DISPLAY_TEXT[isDisplay] + "类别失败，尝试" + DISPLAY_TEXT[isDisplay] +"的分类已处于此状态!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Category category = new Category();
        category.setId(id).setIsDisplay(isDisplay);
        int rows = repository.updateById(category);
        if (rows != 1) {
            String message = DISPLAY_TEXT[isDisplay] + "类别失败，服务器忙，请稍后重试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }

    @Override
    public CategoryStandardVO getStandardById(Long id) {
        log.debug("开始处理【根据ID查询分类详情】业务，参数为: {}", id);
        CategoryStandardVO standardVO = repository.getStandardById(id);
        if (standardVO == null) {
            String message = "查询失败，数据不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        return standardVO;
    }

    @Override
    public List<CategoryTreeItemVO> listTree() {
        log.debug("开始处理【获取类别树】的业务，参数: 无");
        ArrayList<CategoryTreeItemVO> list = new ArrayList<>();

        List<CategoryListItemVO> categoryList = repository.list();
        Map<Long, CategoryListItemVO> categoryMap = transformListToMap(categoryList);
        for (Long key : categoryMap.keySet()) {
            CategoryListItemVO mapItem = categoryMap.get(key);
            if (mapItem.getParentId() == 0) {
                CategoryTreeItemVO treeItem = convertListItemToTreeItem(mapItem);
                list.add(treeItem);

                fillChildren(mapItem, treeItem, categoryList);
            }
        }
        return list;
    }

    @Override
    public PageData<CategoryListItemVO> listByParentId(Long parentId, Integer pageNum) {
        log.debug("开始处理【根据父级ID({})查询分类列表】业务，页码: {}", parentId, pageNum);
        return repository.listByParentId(parentId, pageNum, defaultQueryPageSize);
    }

    @Override
    public PageData<CategoryListItemVO> listByParentId(Long parentId, Integer pageNum, Integer pageSize) {
        log.debug("开始处理【根据父级ID({})查询分类列表】业务，页码: {}, 每页记录数: {}", parentId, pageNum, pageSize);
        return repository.listByParentId(parentId, pageNum, pageSize);
    }

    private Map<Long, CategoryListItemVO> transformListToMap(List<CategoryListItemVO> categoryList) {
        HashMap<Long, CategoryListItemVO> categoryMap = new HashMap<>();
        for (CategoryListItemVO listItem : categoryList) {
            if (listItem.getEnable() == 0) {
                continue;
            }
            categoryMap.put(listItem.getId(), listItem);
        }
        return categoryMap;
    }

    private CategoryTreeItemVO convertListItemToTreeItem(CategoryListItemVO item) {
        return new CategoryTreeItemVO()
                .setValue(item.getId())
                .setLabel(item.getName());
    }

    private void fillChildren(CategoryListItemVO listItem, CategoryTreeItemVO treeItem, List<CategoryListItemVO> categoryList) {
        if (listItem.getIsParent() == 1) {
            treeItem.setChildren(new ArrayList<>());
            Map<Long, CategoryListItemVO> categoryMap = transformListToMap(categoryList);
            for (Long key : categoryMap.keySet()) {
                CategoryListItemVO mapItem = categoryMap.get(key);
                if (listItem.getId().equals(mapItem.getParentId())) {
                    CategoryTreeItemVO treeItemVO = convertListItemToTreeItem(mapItem);
                    treeItem.getChildren().add(treeItemVO);

                    if (mapItem.getIsParent() == 1) {
                        fillChildren(mapItem, treeItemVO, categoryList);
                    }
                }
            }
        }
    }
}
