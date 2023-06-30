package com.example.tea.admin.server.content.dao.persist.repository;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.content.pojo.entity.Article;
import com.example.tea.admin.server.content.pojo.vo.ArticleListItemVO;
import com.example.tea.admin.server.content.pojo.vo.ArticleStandardVO;


/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/14 18:26
 */
public interface IArticleRepository {
    /**
     * 发表文章
     * @param article 发表的文章数据
     * @return 受影响的行数
     */
    int insert(Article article);

    /**
     * 根据ID删除文章
     * @param id 数据ID
     */
    int deleteById(Long id);

    /**
     * 根据ID查询文章标准类
     * @param id 数据ID
     * @return 文章标准VO类对象
     */
    ArticleStandardVO getStandardVO(Long id);

    /**
     * 查询文章列表
     * @param pageNum 页码
     * @param pageSize 每页记录数
     * @return 文章列表
     */
    PageData<ArticleListItemVO> list(Integer pageNum, Integer pageSize);
}
