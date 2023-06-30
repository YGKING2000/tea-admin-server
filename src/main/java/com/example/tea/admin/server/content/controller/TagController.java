package com.example.tea.admin.server.content.controller;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.common.web.JsonResult;
import com.example.tea.admin.server.content.pojo.entity.Tag;
import com.example.tea.admin.server.content.pojo.param.TagAddNewParam;
import com.example.tea.admin.server.content.pojo.param.TagTypeAddNewParam;
import com.example.tea.admin.server.content.pojo.param.TagTypeUpdateInfoParam;
import com.example.tea.admin.server.content.pojo.param.TagUpdateInfoParam;
import com.example.tea.admin.server.content.pojo.vo.TagListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagStandardVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeStandardVO;
import com.example.tea.admin.server.content.service.ITagService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @className TagController
 * @date 2023/06/15 09:28
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/content/tags")
@Api(tags = "2.1 标签管理模块")
public class TagController {
    @Resource
    ITagService tagService;

    public TagController() {
        log.info("创建控制器对象: TagController");
    }

    @ApiOperation(value = "新增标签类别")
    @ApiOperationSupport(order = 100)
    @PostMapping(value = "/type/add-new")
    @PreAuthorize("hasAnyAuthority('/content/tag/add-new')")
    public JsonResult addNew(@Valid TagTypeAddNewParam tagTypeAddNewParam) {
        log.debug("开始处理【新增标签类型】请求，参数: {}", tagTypeAddNewParam);
        tagService.addNew(tagTypeAddNewParam);
        return JsonResult.ok();
    }

    @ApiOperation(value = "新增标签")
    @ApiOperationSupport(order = 110)
    @PostMapping(value = "/add-new")
    @PreAuthorize("hasAnyAuthority('/content/tag/add-new')")
    public JsonResult addNew(@Valid TagAddNewParam tagAddNewParam) {
        log.debug("开始处理【新增标签】请求，参数: {}", tagAddNewParam);
        tagService.addNew(tagAddNewParam);
        return JsonResult.ok();
    }

    @ApiOperation(value = "删除标签")
    @ApiOperationSupport(order = 200)
    @PostMapping(value = "/{id:[0-9]+}/delete")
    @PreAuthorize("hasAnyAuthority('/content/tag/delete')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", required = true, dataType = "Long"),
    })
    public JsonResult delete(@PathVariable @Range(min = 1, message = "删除标签失败，请提交合法的ID值!") Long id) {
        log.debug("开始处理【删除标签】请求，参数: {}", id);
        tagService.delete(id);
        return JsonResult.ok();
    }

    @ApiOperation(value = "删除标签类别")
    @ApiOperationSupport(order = 201)
    @PostMapping(value = "/{id:[0-9]+}/type/delete")
    @PreAuthorize("hasAnyAuthority('/content/tag/delete')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", required = true, dataType = "Long"),
    })
    public JsonResult deleteType(@PathVariable @Range(min = 1, message = "删除标签类别失败，请提交合法的ID值!") Long id) {
        log.debug("开始处理【删除标签类别】请求，参数: {}", id);
        tagService.deleteType(id);
        return JsonResult.ok();
    }

    @ApiOperation(value = "启用标签")
    @ApiOperationSupport(order = 300)
    @PostMapping(value = "/{id:[0-9]+}/enable")
    @PreAuthorize("hasAnyAuthority('/content/tag/update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", required = true, dataType = "Long"),
    })
    public JsonResult setEnable(@PathVariable @Range(min = 1, message = "启用标签失败，请提交合法的ID值!") Long id) {
        log.debug("开始处理【启用标签】请求，参数: {}", id);
        tagService.setEnable(id);
        return JsonResult.ok();
    }

    @ApiOperation(value = "禁用标签")
    @ApiOperationSupport(order = 301)
    @PostMapping(value = "/{id:[0-9]+}/disable")
    @PreAuthorize("hasAnyAuthority('/content/tag/update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", required = true, dataType = "Long"),
    })
    public JsonResult setDisabled(@PathVariable @Range(min = 1, message = "禁用标签失败，请提交合法的ID值!") Long id) {
        log.debug("开始处理【禁用标签】请求，参数: {}", id);
        tagService.setDisable(id);
        return JsonResult.ok();
    }

    @ApiOperation(value = "启用标签类别")
    @ApiOperationSupport(order = 302)
    @PostMapping(value = "/{id:[0-9]+}/type/enable")
    @PreAuthorize("hasAnyAuthority('/content/tag/update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", required = true, dataType = "Long"),
    })
    public JsonResult setTypeEnable(@PathVariable @Range(min = 1, message = "启用标签类别失败，请提交合法的ID值!") Long id) {
        log.debug("开始处理【启用标签类别】请求，参数: {}", id);
        tagService.setTypeEnable(id);
        return JsonResult.ok();
    }

    @ApiOperation(value = "禁用标签类别")
    @ApiOperationSupport(order = 303)
    @PostMapping(value = "/{id:[0-9]+}/type/disable")
    @PreAuthorize("hasAnyAuthority('/content/tag/update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", required = true, dataType = "Long"),
    })
    public JsonResult setTypeDisable(@PathVariable @Range(min = 1, message = "禁用标签类别失败，请提交合法的ID值!") Long id) {
        log.debug("开始处理【禁用标签类别】请求，参数: {}", id);
        tagService.setTypeDisable(id);
        return JsonResult.ok();
    }

    @ApiOperation(value = "根据ID修改标签")
    @ApiOperationSupport(order = 310)
    @PostMapping(value = "/{id:[0-9]+}/update/info")
    @PreAuthorize("hasAnyAuthority('/content/tag/update')")
    public JsonResult update(@Valid TagUpdateInfoParam tagUpdateInfoParam) {
        log.debug("开始处理【根据ID修改标签】请求，参数: {}", tagUpdateInfoParam);
        tagService.updateInfoById(tagUpdateInfoParam);
        return JsonResult.ok();
    }

    @ApiOperation(value = "根据ID修改标签类别")
    @ApiOperationSupport(order = 310)
    @PostMapping(value = "/{id:[0-9]+}/type/update/info")
    @PreAuthorize("hasAnyAuthority('/content/tag/update')")
    public JsonResult updateType(@Valid TagTypeUpdateInfoParam tagTypeUpdateInfoParam) {
        log.debug("开始处理【根据ID修改标签类别】请求，参数: {}", tagTypeUpdateInfoParam);
        tagService.updateTypeInfoById(tagTypeUpdateInfoParam);
        return JsonResult.ok();
    }
    
    @ApiOperation(value = "根据ID查询标签")
    @ApiOperationSupport(order = 400)
    @GetMapping(value = "/{id:[0-9]+}")
    @PreAuthorize("hasAnyAuthority('/content/tag/read')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", required = true, dataType = "Long"),
    })
    public JsonResult getTagById(@PathVariable @Range(min = 1, message = "获取标签详情失败，请提交合法的ID值!") Long id) {
        log.debug("开始处理【根据ID查询标签】请求，参数: {}", id);
        TagStandardVO tag = tagService.getStandardById(id);
        return JsonResult.ok(tag);
    }

    @ApiOperation(value = "根据ID查询标签类别")
    @ApiOperationSupport(order = 401)
    @GetMapping(value = "/{id:[0-9]+}/type")
    @PreAuthorize("hasAnyAuthority('/content/tag/read')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", required = true, dataType = "Long"),
    })
    public JsonResult getTagTypeById(@PathVariable @Range(min = 1, message = "获取标签类别详情失败，请提交合法的ID值!") Long id) {
        log.debug("开始处理【根据ID查询标签类别】请求，参数: {}", id);
        TagTypeStandardVO tagType = tagService.getStandardTypeById(id);
        return JsonResult.ok(tagType);
    }
    
    @ApiOperation(value = "查询标签列表")
    @ApiOperationSupport(order = 411)
    @GetMapping(value = "")
    @PreAuthorize("hasAnyAuthority('/content/tag/read')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer"),
            @ApiImplicitParam(name = "queryType", value = "是否需要分页，查询全部数据时值应为all")
    })
    public JsonResult list(Integer pageNum, String queryType) {
        log.debug("开始处理【查询标签列表】请求，参数有页码: {}", pageNum);
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        PageData<TagListItemVO> list;
        if ("all".equals(queryType)) {
            list = tagService.list(1, Integer.MAX_VALUE);
        } else {
            list = tagService.list(pageNum);
        }
        return JsonResult.ok(list);
    }
    
    @ApiOperation(value = "查询标签类别列表")
    @ApiOperationSupport(order = 410)
    @GetMapping(value = "/tag-type/list")
    @PreAuthorize("hasAnyAuthority('/content/tag/read')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer"),
            @ApiImplicitParam(name = "queryType", value = "是否需要分页，查询全部数据时值应为all")
    })
    public JsonResult listTagType(Integer pageNum, String queryType) {
        log.debug("开始处理【查询标签类别列表】请求，参数: {}", pageNum);
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        PageData<TagTypeListItemVO> listTgaType;
        if ("all".equals(queryType)) {
            listTgaType = tagService.listTgaType(1, Integer.MAX_VALUE);
        } else {
            listTgaType = tagService.listTgaType(pageNum);
        }
        return JsonResult.ok(listTgaType);
    }
}
