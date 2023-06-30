package com.example.tea.admin.server.content.service;

import com.example.tea.admin.server.common.exception.ServiceException;
import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.content.pojo.entity.Tag;
import com.example.tea.admin.server.content.pojo.param.TagAddNewParam;
import com.example.tea.admin.server.content.pojo.param.TagTypeAddNewParam;
import com.example.tea.admin.server.content.pojo.param.TagUpdateInfoParam;
import com.example.tea.admin.server.content.pojo.vo.TagListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagStandardVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeListItemVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @className TagServiceTests
 * @date 2023/06/14 15:52
 */
@SpringBootTest
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"})
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class TagServiceTests {
    @Resource
    ITagService tagService;

    @Test
    void addNew() {
        TagTypeAddNewParam param = new TagTypeAddNewParam();
        param.setName("茶具相关标签002");
        param.setEnable(1);
        param.setSort(188);

        try {
            tagService.addNew(param);
            System.out.println("数据添加成功!");
        } catch (ServiceException e) {
            System.out.println(e.getServiceCode().getValue());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addNew1() {
        TagAddNewParam param = new TagAddNewParam();
        param.setName("茶具");
        param.setEnable(1);
        param.setSort(188);
        param.setParentId(7L);
        try {
            tagService.addNew(param);
            System.out.println("数据添加成功!");
        } catch (ServiceException e) {
            System.out.println(e.getServiceCode().getValue());
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    void delete() {
        try {
            tagService.delete(1L);
            System.out.println("数据删除成功!");
        } catch (ServiceException e) {
            System.out.println(e.getServiceCode().getValue());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void updateInfoById() {
        try {
            TagUpdateInfoParam tag = new TagUpdateInfoParam();
            tag.setId(1000L);
            tag.setName("红红火火恍恍惚惚");
            tagService.updateInfoById(tag);
            System.out.println("修改数据成功!");
        } catch (ServiceException e) {
            System.out.println(e.getServiceCode().getValue());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void setEnable() {
        try {
            Long id = 9L;
            tagService.setEnable(id);
            System.out.println("启用标签成功!");
        } catch (ServiceException e) {
            System.out.println(e.getServiceCode().getValue());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void setDisabled() {
        try {
            Long id = 9L;
            tagService.setDisable(id);
            System.out.println("禁用标签成功!");
        } catch (ServiceException e) {
            System.out.println(e.getServiceCode().getValue());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void setTypeEnable() {
        try {
            Long id = 8L;
            tagService.setTypeEnable(id);
            System.out.println("启用标签类别成功!");
        } catch (ServiceException e) {
            System.out.println(e.getServiceCode().getValue());
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    void setTypeDisable() {
        try {
            Long id = 1L;
            tagService.setTypeDisable(id);
            System.out.println("禁用标签类别成功!");
        } catch (ServiceException e) {
            System.out.println(e.getServiceCode().getValue());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getStandardById() {
        try {
            TagStandardVO standardVO = tagService.getStandardById(1000L);
            System.out.println("数据查询成功，结果为: " + standardVO);
        } catch (ServiceException e) {
            System.out.println(e.getServiceCode().getValue());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void listTgaType1() {
        Integer pageNum = 1;
        PageData<TagTypeListItemVO> listTgaType = tagService.listTgaType(pageNum);
        System.out.println(listTgaType);
    }

    @Test
    void listTgaType2() {
        Integer pageNum = 1;
        Integer pageSize = 3;
        PageData<TagTypeListItemVO> listTgaType = tagService.listTgaType(pageNum, pageSize);
        System.out.println(listTgaType);
    }

    @Test
    void list1() {
        Integer pageNum = 1;
        PageData<TagListItemVO> list = tagService.list(pageNum);
        System.out.println(list);
    }

    @Test
    void list2() {
        Integer pageNum = 1;
        Integer pageSize = 5;
        PageData<TagListItemVO> list = tagService.list(pageNum, pageSize);
        System.out.println(list);
    }
}
