package com.example.tea.admin.server.content.dao.persist.repository;

import com.example.tea.admin.server.content.pojo.entity.Article;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @description
 * @className ArticleRepositoryTests
 * @date 2023/06/14 14:28
 */
@SpringBootTest
public class ArticleRepositoryTests {
    @Resource
    IArticleRepository repository;

    @Test
    @Sql(value = "classpath:/sql/truncate_table.sql")
    @Sql(scripts = "classpath:/sql/truncate_table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void insert() {
        Article article = new Article();
        article.setAuthorId(1L);
        article.setAuthorName("李逍遥");
        article.setCategoryId(3L);
        repository.insert(article);
        System.out.println(article);
    }
}
