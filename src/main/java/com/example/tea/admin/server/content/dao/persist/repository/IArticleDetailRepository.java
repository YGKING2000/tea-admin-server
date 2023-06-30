package com.example.tea.admin.server.content.dao.persist.repository;

import com.example.tea.admin.server.content.pojo.entity.ArticleDetail;
import com.example.tea.admin.server.content.pojo.vo.ArticleDetailStandardVO;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/14 18:19
 */
public interface IArticleDetailRepository {
    int insert(ArticleDetail articleDetail);
    
    int deleteById(Long articleId);

    ArticleDetailStandardVO getStandardByArticleId(Long id);
}
