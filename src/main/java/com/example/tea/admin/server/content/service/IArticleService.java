package com.example.tea.admin.server.content.service;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.common.security.CurrentPrincipal;
import com.example.tea.admin.server.content.pojo.param.ArticleAddNewParam;
import com.example.tea.admin.server.content.pojo.vo.ArticleListItemVO;
import com.example.tea.admin.server.content.pojo.vo.ArticleStandardVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/14 14:52
 */
@Transactional
public interface IArticleService {
    /**
     * 发表文章
     * @param principal 当事人
     * @param remoteAddr IP地址
     * @param articleAddNewParam 发表的文章数据
     */
    void addNew(CurrentPrincipal principal, String remoteAddr, ArticleAddNewParam articleAddNewParam);

    /**
     * 根据ID删除文章
     * @param id 数据ID
     */
    void delete(Long id);

    PageData<ArticleListItemVO> list(Integer pageNum, Integer pageSize);

    PageData<ArticleListItemVO> list(Integer pageNum);

    ArticleStandardVO getStandardById(Long id);
}
