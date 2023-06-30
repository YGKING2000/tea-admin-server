package com.example.tea.admin.server.content.dao.persist.repository;

import com.example.tea.admin.server.content.pojo.entity.ArticleDetail;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @description
 * @className ArticleDetailRepositoryTests
 * @date 2023/06/14 14:28
 */
@SpringBootTest
public class ArticleDetailRepositoryTests {
    @Resource
    IArticleDetailRepository repository;

    @Test
    @Sql(value = "classpath:/sql/truncate_table.sql")
    @Sql(scripts = "classpath:/sql/truncate_table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void insert() {
        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setArticleId(1L);
        articleDetail.setDetail("我问为什么那女孩传简讯给我");
        repository.insert(articleDetail);
        System.out.println(articleDetail);
    }
}
