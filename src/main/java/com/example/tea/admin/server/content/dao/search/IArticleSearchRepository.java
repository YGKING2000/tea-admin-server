package com.example.tea.admin.server.content.dao.search;

import com.example.tea.admin.server.content.pojo.vo.ArticleSearchVO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/06 11:56
 */
@Repository
public interface IArticleSearchRepository extends ElasticsearchRepository<ArticleSearchVO, Long> {
}
