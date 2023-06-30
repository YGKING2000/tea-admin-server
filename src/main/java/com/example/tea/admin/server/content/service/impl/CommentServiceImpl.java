package com.example.tea.admin.server.content.service.impl;

import com.example.tea.admin.server.common.exception.ServiceException;
import com.example.tea.admin.server.common.web.ServiceCode;
import com.example.tea.admin.server.content.dao.persist.repository.ICommentRepository;
import com.example.tea.admin.server.content.pojo.entity.Comment;
import com.example.tea.admin.server.content.pojo.param.CommentAddNewParam;
import com.example.tea.admin.server.content.service.ICommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @className CommentServiceImpl
 * @date 2023/06/14 14:55
 */
@Slf4j
@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    ICommentRepository commentRepository;

    public CommentServiceImpl() {
        log.info("创建业务对象: CommentServiceImpl");
    }
    
    @Override
    public void addNew(CommentAddNewParam commentAddNewParam) {
        log.debug("开始处理【新增评论】业务，参数: {}", commentAddNewParam);

        Comment comment = new Comment();
        BeanUtils.copyProperties(commentAddNewParam, comment);
        int rows = commentRepository.insert(comment);
        if (rows != 1) {
            String message = "新增评论失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_INSERT, message);
        }
    }
}
