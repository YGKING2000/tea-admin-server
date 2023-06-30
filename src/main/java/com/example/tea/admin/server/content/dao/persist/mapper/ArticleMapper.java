package com.example.tea.admin.server.content.dao.persist.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tea.admin.server.content.pojo.entity.Article;
import com.example.tea.admin.server.content.pojo.vo.ArticleListItemVO;
import com.example.tea.admin.server.content.pojo.vo.ArticleStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 1.0
 * @date 2023/06/13 19:32
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
    ArticleStandardVO getStandardById(Long id);
    
    List<ArticleListItemVO> list();
}
