package com.example.tea.admin.server.content.dao.persist.repository.impl;

import com.example.tea.admin.server.content.dao.persist.mapper.CommentMapper;
import com.example.tea.admin.server.content.dao.persist.repository.ICommentRepository;
import com.example.tea.admin.server.content.pojo.entity.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @className CommentRepositoryImpl
 * @date 2023/06/14 18:27
 */
@Slf4j
@Repository
public class CommentRepositoryImpl implements ICommentRepository {
    @Resource
    CommentMapper commentMapper;

    public CommentRepositoryImpl() {
        log.info("创建存储库对象: CommentRepositoryImpl");
    }
    
    @Override
    public int insert(Comment comment) {
        log.debug("开始执行向【内容-评论表】中插入数据: {}", comment);
        
        return commentMapper.insert(comment);
    }
}
