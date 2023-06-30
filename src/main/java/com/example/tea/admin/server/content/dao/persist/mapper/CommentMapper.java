package com.example.tea.admin.server.content.dao.persist.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tea.admin.server.content.pojo.entity.Comment;
import com.example.tea.admin.server.content.pojo.vo.CommentStandardVO;
import org.springframework.stereotype.Repository;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 1.0
 * @date 2023/06/13 20:00
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    CommentStandardVO getStandardById(Long id);
}
