package com.example.tea.admin.server.content.dao.persist.repository;

import com.example.tea.admin.server.content.pojo.entity.UpDownLog;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/14 18:26
 */
public interface IUpDownLogRepository {
    int insert(UpDownLog upDownLog);
}
