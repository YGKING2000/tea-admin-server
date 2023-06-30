package com.example.tea.admin.server.content.service;

import com.example.tea.admin.server.content.pojo.param.CommentAddNewParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/14 14:52
 */
@Transactional
public interface ICommentService {
    void addNew(CommentAddNewParam commentAddNewParam);
}
