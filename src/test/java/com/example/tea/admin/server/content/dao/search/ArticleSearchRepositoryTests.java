package com.example.tea.admin.server.content.dao.search;

import com.example.tea.admin.server.content.dao.persist.mapper.ArticleMapper;
import com.example.tea.admin.server.content.pojo.vo.ArticleSearchVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/06 12:00
 */
@SpringBootTest
public class ArticleSearchRepositoryTests {
    @Resource
    private IArticleSearchRepository repository;
    
    @Resource
    private ArticleMapper mapper;
    
    @Test
    void save() {
        ArticleSearchVO articleSearchVO = new ArticleSearchVO();
        articleSearchVO.setId(1L);
        articleSearchVO.setAuthorName("YGKING");
        articleSearchVO.setTitle("我怀年的");
        articleSearchVO.setBrief("我问为什么那女孩传简讯给我，而你为什么不解释低着头沉默");
        repository.save(articleSearchVO);
    }
    
    @Test
    void saveAll() {
        List<ArticleSearchVO> articleSearchVOS = mapper.listSearch();
        repository.saveAll(articleSearchVOS);
    }
}
