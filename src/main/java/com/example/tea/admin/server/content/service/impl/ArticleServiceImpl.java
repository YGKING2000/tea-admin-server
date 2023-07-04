package com.example.tea.admin.server.content.service.impl;

import com.example.tea.admin.server.common.exception.ServiceException;
import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.common.security.CurrentPrincipal;
import com.example.tea.admin.server.common.web.ServiceCode;
import com.example.tea.admin.server.content.dao.persist.repository.IArticleDetailRepository;
import com.example.tea.admin.server.content.dao.persist.repository.IArticleRepository;
import com.example.tea.admin.server.content.pojo.entity.Article;
import com.example.tea.admin.server.content.pojo.entity.ArticleDetail;
import com.example.tea.admin.server.content.pojo.param.ArticleAddNewParam;
import com.example.tea.admin.server.content.pojo.vo.ArticleDetailStandardVO;
import com.example.tea.admin.server.content.pojo.vo.ArticleListItemVO;
import com.example.tea.admin.server.content.pojo.vo.ArticleStandardVO;
import com.example.tea.admin.server.content.pojo.vo.TagListItemVO;
import com.example.tea.admin.server.content.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @className ArticleServiceImpl
 * @date 2023/06/14 14:55
 */
@Slf4j
@Service
public class ArticleServiceImpl implements IArticleService {
    @Resource
    private IArticleRepository articleRepository;

    @Resource
    private IArticleDetailRepository articleDetailRepository;

    @Value("${tea-store.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;

    public ArticleServiceImpl() {
        log.info("创建业务对象: ArticleServiceImpl");
    }

    @Override
    public void addNew(CurrentPrincipal principal, String remoteAddr, ArticleAddNewParam articleAddNewParam) {
        log.debug("开始处理【发表文章】业务，当事人为:{}，IP为: {}，发表数据为: {}", principal, remoteAddr, articleAddNewParam);

        Article article = new Article();
        BeanUtils.copyProperties(articleAddNewParam, article);
        article.setAuthorId(principal.getId())
                .setAuthorName(principal.getUsername())
                .setIp(remoteAddr)
                .setUpCount(0)
                .setDownCount(0)
                .setClickCount(0)
                .setCommentCount(0)
                .setCheckState(0)
                .setDisplayState(0);
        int rows = articleRepository.insert(article);
        if (rows != 1) {
            String message = "新增文章失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_INSERT, message);
        }

        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setArticleId(article.getId()).setDetail(articleAddNewParam.getDetail());
        rows = articleDetailRepository.insert(articleDetail);
        if (rows != 1) {
            String message = "发表文章失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_INSERT, message);
        }
    }

    @Override
    public void delete(Long id) {
        log.debug("开始处理【根据ID删除文章】业务，参数为: {}", id);
        
        ArticleStandardVO article = articleRepository.getStandardById(id);
        if (article == null) {
            String message = "删除文章失败，尝试删除的文章不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        Long articleId = article.getId();
        ArticleDetailStandardVO articleDetail = articleDetailRepository.getStandardByArticleId(articleId);
        
        
        articleRepository.deleteById(id);
    }

    @Override
    public PageData<ArticleListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始处理【查询文章列表】业务，页码为: {}，每页记录数为: {}", pageNum, pageSize);
        return articleRepository.list(pageNum, pageSize);
    }

    @Override
    public PageData<ArticleListItemVO> list(Integer pageNum) {
        log.debug("开始处理【查询文章列表】业务，页码为: {}", pageNum);
        return articleRepository.list(pageNum, defaultQueryPageSize);
    }

    @Override
    public ArticleStandardVO getStandardById(Long id) {
        log.debug("开始处理【根据ID查询查询文章详情】业务，参数为: {}", id);
        return articleRepository.getStandardById(id);
    }
}
