package com.example.tea.admin.server.content.service;

import com.example.tea.admin.server.common.security.CurrentPrincipal;
import com.example.tea.admin.server.content.pojo.param.ArticleAddNewParam;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.test.context.jdbc.Sql;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @className TagServiceTests
 * @date 2023/06/14 15:52
 */
@SpringBootTest
public class ArticleServiceTests {
    @Resource
    private IArticleService articleService;
    
    @Test
    @Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"})
    @Sql(scripts = "classpath:/sql/truncate_table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    // void addNew(@AuthenticationPrincipal CurrentPrincipal principal, HttpServletRequest request) {
    void addNew() {
        // String remoteAddr = request.getRemoteAddr();
        // ArticleAddNewParam param = new ArticleAddNewParam();
        // param.setCategoryId(9L);

        // articleService.addNew(principal, remoteAddr, param);
        // System.out.println("数据添加成功!");
    }
    
    @Test
    void rebuildSearch() {
        articleService.rebuildSearch();
    }
}
