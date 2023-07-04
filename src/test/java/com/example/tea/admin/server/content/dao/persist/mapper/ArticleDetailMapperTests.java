package com.example.tea.admin.server.content.dao.persist.mapper;

import com.example.tea.admin.server.content.pojo.entity.ArticleDetail;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @description
 * @className ArticleDetailMapperTests
 * @date 2023/06/13 20:49
 */
@SpringBootTest
public class ArticleDetailMapperTests {
    @Resource
    ArticleDetailMapper mapper;
    
    @Test
    void insert() {
        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setArticleId(2L);
        articleDetail.setDetail("而你为什么不解释低着头沉默");
        int rows = mapper.insert(articleDetail);
        System.out.println("插入数据成功，影响行数为:" + rows);
    }
    
    @Test
    void getStandardById() {
        // System.out.println(GoodsMapper.getStandardById(2L));
    }
}
