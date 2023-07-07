package com.example.tea.admin.server.dict.controller;

import com.example.tea.admin.server.common.web.JsonResult;
import com.example.tea.admin.server.dict.pojo.vo.DistrictListItemVO;
import com.example.tea.admin.server.dict.service.IDistrictService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理省市区相关请求的控制器
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/mall/dict/district")
@Validated
@Api(tags = "9.1. 商城管理-字典数据-省市区")
public class DistrictController {

    @Resource
    private IDistrictService districtService;

    public DistrictController() {
        log.debug("创建控制器类对象：DistrictController");
    }

    @GetMapping("/list-by-parent")
    @ApiOperation("根据父级查询子级地区列表")
    @ApiOperationSupport(order = 420)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", value = "父级单位ID，如果无父级使用0", required = true, dataType = "long")
    })
    public JsonResult listByParentId(@RequestParam @Range(message = "请提交有效的父级单位ID值！") Long parentId) {
        log.debug("开始处理【根据父级查询子级地区列表】的请求，参数：{}", parentId);
        List<DistrictListItemVO> districtList = districtService.listByParentId(parentId);
        return JsonResult.ok(districtList);
    }

}
