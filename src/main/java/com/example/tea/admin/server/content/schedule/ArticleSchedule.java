package com.example.tea.admin.server.content.schedule;

import com.example.tea.admin.server.content.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/06 15:03
 */
@Slf4j
@Component
public class ArticleSchedule {
    @Resource
    private IArticleService service;
    
    public ArticleSchedule() {
        log.debug("创建计划类对象: ArticleSchedule");
    }
    
    @Scheduled(fixedRate = 10 * 60 * 1000)
    public void rebuild() {
        log.debug("开始执行【更新搜索服务器中的文章列表】的计划更新，无参数");
        service.rebuildSearch();
    }
}
