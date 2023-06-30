package com.example.tea.admin.server.content.dao.persist.repository;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.content.pojo.entity.Tag;
import com.example.tea.admin.server.content.pojo.vo.TagListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagStandardVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeListItemVO;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @description
 * @className TagRepositoryTests
 * @date 2023/06/14 14:28
 */
@SpringBootTest
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"})
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class TagRepositoryTests {
    @Resource
    ITagRepository repository;

    @Test
    void insert() {
        Tag tag = new Tag();
        tag.setName("测试添加内容标签");
        repository.insert(tag);
        System.out.println(tag);
    }

    @Test
    void deleteById() {
        int rows = repository.deleteById(9L);
        System.out.println("受影响的行数为: " + rows);
    }

    @Test
    void updateById() {
        Tag tag = new Tag();
        tag.setId(9L);
        tag.setEnable(0);
        tag.setName("红红火火恍恍惚惚");
        int rows = repository.updateById(tag);
        System.out.println("受影响的行数为: " + rows);
    }

    @Test
    void getStandardById() {
        TagStandardVO tagStandardVO = repository.getStandardById(9L);
        System.out.println(tagStandardVO);
    }
    
    @Test
    void listTgaType() {
        PageData<TagTypeListItemVO> pageData = repository.listTgaType(1, 3);
        System.out.println(pageData);
    }

    @Test
    void list() {
        PageData<TagListItemVO> pageData = repository.list(1, 4);
        System.out.println(pageData);
    }
}
