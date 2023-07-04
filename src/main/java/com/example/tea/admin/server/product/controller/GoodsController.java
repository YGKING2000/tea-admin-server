package com.example.tea.admin.server.product.controller;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.common.web.JsonResult;
import com.example.tea.admin.server.product.pojo.param.GoodsAddNewParam;
import com.example.tea.admin.server.product.pojo.vo.GoodsListItemVO;
import com.example.tea.admin.server.product.service.IGoodsService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/04 10:30
 */
@Slf4j
@Validated
@RestController
@Api(tags = "3.1 商品管理模块")
@RequestMapping("/product/goods")
public class GoodsController {
    @Resource
    private IGoodsService service;

    public GoodsController() {
        log.debug("创建控制器对象: GoodsController");
    }

    @ApiOperation("上架商品")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public JsonResult addNew(@Validated GoodsAddNewParam goodsAddNewParam) {
        log.debug("开始处理【上架商品】请求，参数为: {}", goodsAddNewParam);
        service.addNew(goodsAddNewParam);
        return JsonResult.ok();
    }
    
    @ApiOperation("根据ID删除商品")
    @ApiOperationSupport(order = 200)
    @PostMapping("/{id:[0-9]+}/delete")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", example = "3", dataType = "Long")
    })
    public JsonResult delete(@PathVariable Long id) {
        log.debug("开始处理【根据ID删除商品】请求，参数为: {}", id);
        service.deleteById(id);
        return JsonResult.ok();
    }

    @ApiOperation("根据ID查询商品详情")
    @ApiOperationSupport(order = 400)
    @GetMapping("/{id:[0-9]+}/detail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", example = "1", dataType = "Long")
    })
    public JsonResult detail(@PathVariable Long id) {
        log.debug("开始处理【根据ID查询商品详情】请求，参数为: {}", id);
        return JsonResult.ok(service.getStandardVO(id));
    }

    @ApiOperation("根据分类ID分页查询商品数据")
    @ApiOperationSupport(order = 410)
    @GetMapping("/list-by-category")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="categoryId", value = "分类ID", example = "1", dataType = "Long"),
            @ApiImplicitParam(name ="pageNum", value = "页码", example = "1", dataType = "Integer"),
            @ApiImplicitParam(name ="pageSize", value = "每页记录数", example = "5", dataType = "Integer"),
            @ApiImplicitParam(name ="queryType", value = "查询类型", example = "all")
    })
    public JsonResult listByCategory(Long categoryId,Integer pageNum, Integer pageSize, String queryType) {
        log.debug("开始处理【根据分类ID({})分页查询商品数据】请求，页码: {}, 每页记录数: {}", categoryId, pageNum, pageSize);
        PageData<GoodsListItemVO> pageData;
        if ("all".equals(queryType)) {
            pageData = service.listByCategory(categoryId, 1, Integer.MAX_VALUE);
        } else {
            if (pageNum < 1) pageNum = 1;
            if (pageSize < 5 || pageSize > 50) pageSize = 5;
            pageData = service.listByCategory(categoryId, pageNum, pageSize);
        }
        return JsonResult.ok(pageData);
    }
}
