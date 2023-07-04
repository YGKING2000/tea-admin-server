package com.example.tea.admin.server.product.controller;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.common.web.JsonResult;
import com.example.tea.admin.server.product.pojo.param.CategoryAddNewParam;
import com.example.tea.admin.server.product.pojo.param.CategoryUpdateParam;
import com.example.tea.admin.server.product.pojo.vo.CategoryListItemVO;
import com.example.tea.admin.server.product.pojo.vo.CategoryStandardVO;
import com.example.tea.admin.server.product.pojo.vo.CategoryTreeItemVO;
import com.example.tea.admin.server.product.service.ICategoryService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/27 11:29
 */
@Slf4j
@Validated
@RestController("productCategoryController")
@Api(tags = "3.2 分类管理模块")
@RequestMapping("/product/categories")
public class CategoryController {
    @Resource
    private ICategoryService service;

    public CategoryController() {
        log.debug("创建控制器对象: CategoryController");
    }

    @ApiOperation("新增分类")
    @PreAuthorize("hasAuthority('/content/category/add-new')")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public JsonResult addNew(CategoryAddNewParam param) {
        log.debug("开始处理【新增分类】请求，参数为: {}", param);
        service.addNew(param);
        return JsonResult.ok();
    }
    
    @ApiOperation("根据ID删除分类")
    @ApiOperationSupport(order = 200)
    @PostMapping("/{id:[0-9]+}/delete")
    @PreAuthorize("hasAuthority('/content/category/delete')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", dataType = "Long", required = true, example = "3")
    })
    public JsonResult delete(@PathVariable Long id) {
        log.debug("开始处理【根据ID删除分类】请求，参数为: {}", id);
        service.delete(id);
        return JsonResult.ok();
    }
    
    @ApiOperation("根据ID修改分类")
    @ApiOperationSupport(order = 300)
    @PostMapping("/{id:[0-9]+}/update")
    @PreAuthorize("hasAuthority('/content/category/update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", dataType = "Long", required = true, example = "2")
    })
    public JsonResult update(@PathVariable @Validated Long id, @Validated CategoryUpdateParam categoryUpdateParam) {
        log.debug("开始处理【根据ID修改分类】请求，参数为: {}", id);
        service.update(id, categoryUpdateParam);
        return JsonResult.ok();
    }

    @ApiOperation(value = "启用分类")
    @ApiOperationSupport(order = 301)
    @PostMapping(value = "/{id:[0-9]+}/enable")
    @PreAuthorize("hasAuthority('/content/category/update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", required = true, dataType = "Long"),
    })
    public JsonResult setEnable(@PathVariable @Range(min = 1, message = "启用分类失败，请提交合法的ID值!") Long id) {
        log.debug("开始处理【启用分类】请求，参数: {}", id);
        service.setEnable(id);
        return JsonResult.ok();
    }

    @ApiOperation(value = "禁用分类")
    @ApiOperationSupport(order = 302)
    @PostMapping(value = "/{id:[0-9]+}/disable")
    @PreAuthorize("hasAuthority('/content/category/update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", required = true, dataType = "Long"),
    })
    public JsonResult setDisabled(@PathVariable @Range(min = 1, message = "禁用分类失败，请提交合法的ID值!") Long id) {
        log.debug("开始处理【禁用分类】请求，参数: {}", id);
        service.setDisable(id);
        return JsonResult.ok();
    }

    @ApiOperation(value = "显示分类")
    @ApiOperationSupport(order = 303)
    @PostMapping(value = "/{id:[0-9]+}/display")
    @PreAuthorize("hasAuthority('/content/category/update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", required = true, dataType = "Long"),
    })
    public JsonResult setDisplay(@PathVariable @Range(min = 1, message = "显示分类失败，请提交合法的ID值!") Long id) {
        log.debug("开始处理【显示分类】请求，参数: {}", id);
        service.setDisplay(id);
        return JsonResult.ok();
    }

    @ApiOperation(value = "隐藏分类")
    @ApiOperationSupport(order = 304)
    @PostMapping(value = "/{id:[0-9]+}/hidden")
    @PreAuthorize("hasAuthority('/content/category/update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", required = true, dataType = "Long"),
    })
    public JsonResult setHidden(@PathVariable @Range(min = 1, message = "隐藏分类失败，请提交合法的ID值!") Long id) {
        log.debug("开始处理【隐藏分类】请求，参数: {}", id);
        service.setHidden(id);
        return JsonResult.ok();
    }
    
    @GetMapping("/{id:[0-9]+}")
    @ApiOperation("根据ID查询分类详情")
    @ApiOperationSupport(order = 400)
    @PreAuthorize("hasAuthority('/content/category/read')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", required = true, example = "1", dataType = "Long")
    })
    public JsonResult getStandardById(@PathVariable @Range(min = 1, message = "查询失败，请提交合法的ID值!") Long id) {
        log.debug("开始处理【根据ID查询分类详情】请求，参数为: {}", id);
        CategoryStandardVO categoryStandardVO = service.getStandardById(id);
        return JsonResult.ok(categoryStandardVO);
    }

    @GetMapping("/tree")
    @ApiOperation("查询类别树")
    @ApiOperationSupport(order = 410)
    @PreAuthorize("hasAuthority('/content/category/read')")
    public JsonResult listTree() {
        log.debug("开始处理【获取类别树】的请求，参数: 无");
        List<CategoryTreeItemVO> categoryTree = service.listTree();
        return JsonResult.ok(categoryTree);
    }

    @GetMapping("/list-by-parent")
    @PreAuthorize("hasAuthority('/content/category/read')")
    @ApiOperation("根据父级ID查询子级分类")
    @ApiOperationSupport(order = 420)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", value = "父级ID", dataType = "Long", required = true, example = "2"),
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", required = true, example = "1"),
            @ApiImplicitParam(name = "queryType", value = "查询类型", required = true, example = "all")
    })
    public JsonResult list(
            @Range(message = "请提交合法的父级ID值!") Long parentId,
            @Range(min = 1, message = "请提交有效的页码值!") Integer pageNum,
            String queryType) {
        log.debug("开始处理【根据父级ID查询子级分类】请求，参数有父级ID: {}，页码: {}", parentId, pageNum);
        PageData<CategoryListItemVO> pageData;
        if ("all".equals(queryType)) {
            pageData = service.listByParentId(parentId, 1, Integer.MAX_VALUE);
        } else {
            pageNum = pageNum == null ? 1 : pageNum;
            pageData = service.listByParentId(parentId, pageNum);
        }
        return JsonResult.ok(pageData);
    }
}
