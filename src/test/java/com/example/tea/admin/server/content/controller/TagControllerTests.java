package com.example.tea.admin.server.content.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @className TagControllerTests
 * @date 2023/06/15 10:22
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TagControllerTests {
    @Resource
    MockMvc mockMvc;

    @Test
    /*@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"})
    @Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)*/
    void addNew() throws Throwable {
        String url = "/content/tags/add-new";
        String name = "茶具相关标签001";
        String sort = "99";
        String enable = "1";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .param("name", name)
                .param("sort", sort)
                .param("enable", enable)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"})
    @Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void addNew1() throws Throwable {
        String url = "/content/tags/add-new";
        String name = "茶具相关标签001";
        String sort = "99";
        String enable = "1";
        String parentId = "7";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .param("name", name)
                .param("sort", sort)
                .param("enable", enable)
                .param("parentId", parentId)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(MockMvcResultHandlers.print());
    }
}
