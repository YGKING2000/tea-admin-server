package com.example.tea.admin.server.content.dao.persist.mapper;

import com.example.tea.admin.server.content.pojo.entity.Article;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @description
 * @className ArticleMapperTests
 * @date 2023/06/13 19:40
 */
@SpringBootTest
public class ArticleMapperTests {
    @Resource
    ArticleMapper mapper;
    
    @Test
    void insert() {
        Article article = new Article();
        article.setAuthorId(1L);
        article.setAuthorName("胡歌");
        article.setCategoryId(3L);
        article.setTitle("仙剑奇侠传三");
        int rows = mapper.insert(article);
        System.out.println("插入数据成功，影响数据条数为:" + rows);
    }
    
    @Test
    void getStandardById() {
        System.out.println(mapper.getStandardById(2L));
    }
}
