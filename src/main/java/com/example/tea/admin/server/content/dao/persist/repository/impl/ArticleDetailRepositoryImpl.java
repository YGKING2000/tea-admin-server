package com.example.tea.admin.server.content.dao.persist.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tea.admin.server.content.dao.persist.mapper.ArticleDetailMapper;
import com.example.tea.admin.server.content.dao.persist.repository.IArticleDetailRepository;
import com.example.tea.admin.server.content.pojo.entity.ArticleDetail;
import com.example.tea.admin.server.content.pojo.vo.ArticleDetailStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @className ArticleDetailRepositoryImpl
 * @date 2023/06/14 18:22
 */
@Slf4j
@Repository
public class ArticleDetailRepositoryImpl implements IArticleDetailRepository {
    @Resource
    ArticleDetailMapper mapper;
    
    public ArticleDetailRepositoryImpl() {
        log.info("创建存储库对象: ArticleDetailRepositoryImpl");
    }

    @Override
    public int insert(ArticleDetail articleDetail) {
        log.debug("开始执行【新增文章详情表】操作，参数为: {}", articleDetail);
        return mapper.insert(articleDetail);
    }

    @Override
    public int deleteById(Long articleId) {
        QueryWrapper<ArticleDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("article_id", articleId);
        return mapper.delete(wrapper);
    }

    @Override
    public ArticleDetailStandardVO getStandardByArticleId(Long id) {
        return mapper.getStandardByArticleId(id);
    }
}
