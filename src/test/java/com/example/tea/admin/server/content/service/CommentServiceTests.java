package com.example.tea.admin.server.content.service;

import com.example.tea.admin.server.content.pojo.param.CommentAddNewParam;
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
public class CommentServiceTests {
    @Resource
    ICommentService commentService;

    @Test
    @Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"})
    @Sql(scripts = "classpath:/sql/truncate_table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void addNew() {
        CommentAddNewParam param = new CommentAddNewParam();
        param.setAuthorId(1L);
        commentService.addNew(param);
        System.out.println("数据添加成功!");
    }
}
