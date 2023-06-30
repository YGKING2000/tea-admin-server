package com.example.tea.admin.server.content.controller;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.common.security.CurrentPrincipal;
import com.example.tea.admin.server.common.web.JsonResult;
import com.example.tea.admin.server.content.pojo.param.ArticleAddNewParam;
import com.example.tea.admin.server.content.pojo.vo.ArticleListItemVO;
import com.example.tea.admin.server.content.service.IArticleService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/28 16:22
 */
@Slf4j
@Validated
@RestController
@Api(tags = "2.3 文章管理模块")
@RequestMapping("/content/articles")
public class ArticleController {
    @Resource
    private IArticleService service;
    
    @PostMapping("/add-new")
    @ApiOperation("发表文章")
    @ApiOperationSupport(order = 100)
    @PreAuthorize("hasAnyAuthority('/content/category/add-new')")
    public JsonResult addNew(
            @AuthenticationPrincipal @ApiIgnore CurrentPrincipal currentPrincipal,
            @ApiIgnore HttpServletRequest request,
            @Validated ArticleAddNewParam articleAddNewParam) {
        log.debug("开始处理【发表文章】请求，参数为: {}", articleAddNewParam);
        String remoteAddr = request.getRemoteAddr();
        service.addNew(currentPrincipal, remoteAddr, articleAddNewParam);
        return JsonResult.ok();
    }

    @PostMapping("/{id:[0-9]+}/delete")
    @ApiOperation("删除文章")
    @ApiOperationSupport(order = 200)
    @PreAuthorize("hasAnyAuthority('/content/category/delete')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", dataType = "Long", required = true)
    })
    public JsonResult delete(@PathVariable @Range(min = 1, message = "请提交合法的ID值!") Long id) {
        log.debug("开始处理【删除文章】请求，参数为: {}", id);
        service.delete(id);
        return JsonResult.ok();
    }

    @ApiOperation(value = "查询文章列表")
    @ApiOperationSupport(order = 400)
    @GetMapping(value = "/list")
    @PreAuthorize("hasAnyAuthority('/content/article/read')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "queryType", value = "是否需要分页，查询全部数据时值应为all")
    })
    public JsonResult list(Integer pageNum, String queryType) {
        log.debug("开始处理【查询文章列表】请求，参数有页码: {}", pageNum);
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        PageData<ArticleListItemVO> list;
        if ("all".equals(queryType)) {
            list = service.list(1, Integer.MAX_VALUE);
        } else {
            list = service.list(pageNum);
        }
        return JsonResult.ok(list);
    }
}
