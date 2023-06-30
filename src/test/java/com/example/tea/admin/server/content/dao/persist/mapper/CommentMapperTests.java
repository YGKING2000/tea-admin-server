package com.example.tea.admin.server.content.dao.persist.mapper;

import com.example.tea.admin.server.content.pojo.entity.Comment;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @description
 * @className CommentMapperTests
 * @date 2023/06/13 20:12
 */
@SpringBootTest
public class CommentMapperTests {
    @Resource
    CommentMapper mapper;
    
    @Test
    void insert() {
        Comment comment = new Comment();
        comment.setAuthorId(1L);
        comment.setContent("真相只有一个!");
        comment.setAuthorName("李逍遥");
        int rows = mapper.insert(comment);
        System.out.println("插入数据成功，影响数据行数为:" + rows);
    }
    
    @Test
    void getStandardById() {
        System.out.println(mapper.getStandardById(3L));
    }
}
