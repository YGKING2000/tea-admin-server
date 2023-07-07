package com.example.tea.admin.server.content.dao.persist.repository.impl;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.common.util.PageInfoToPageDataConverter;
import com.example.tea.admin.server.content.dao.persist.mapper.ArticleMapper;
import com.example.tea.admin.server.content.dao.persist.repository.IArticleRepository;
import com.example.tea.admin.server.content.pojo.entity.Article;
import com.example.tea.admin.server.content.pojo.vo.ArticleListItemVO;
import com.example.tea.admin.server.content.pojo.vo.ArticleSearchVO;
import com.example.tea.admin.server.content.pojo.vo.ArticleStandardVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @className ArticleRepositoryImpl
 * @date 2023/06/14 18:27
 */
@Slf4j
@Repository
public class ArticleRepositoryImpl implements IArticleRepository {
    @Resource
    private ArticleMapper mapper;
    
    public ArticleRepositoryImpl() {
        log.info("创建存储库对象: ArticleRepositoryImpl");
    }

    @Override
    public int insert(Article article) {
        log.debug("开始执行【发表文章】操作，参数为: {}", article);
        
        return mapper.insert(article);
    }

    @Override
    public int deleteById(Long id) {
        log.debug("开始执行【根据ID删除文章】操作，参数为: {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public ArticleStandardVO getStandardById(Long id) {
        log.debug("开始执行【根据ID查询文章】操作，参数为: {}", id);
        return mapper.getStandardById(id);
    }

    @Override
    public PageData<ArticleListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始执行【查询文章列表】操作，页码: {}，每页记录数: {}", pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleListItemVO> list = mapper.list();

        PageInfo<ArticleListItemVO> pageInfo = new PageInfo<>(list);
        return PageInfoToPageDataConverter.convert(pageInfo);
    }

    @Override
    public PageData<ArticleSearchVO> listSearch(Integer pageNum, Integer pageSize) {
        log.debug("开始执行【查询放入elsticsearch中的文章列表】操作，页码: {}，每页记录数: {}", pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleSearchVO> list = mapper.listSearch();

        PageInfo<ArticleSearchVO> pageInfo = new PageInfo<>(list);
        return PageInfoToPageDataConverter.convert(pageInfo);
    }
}
