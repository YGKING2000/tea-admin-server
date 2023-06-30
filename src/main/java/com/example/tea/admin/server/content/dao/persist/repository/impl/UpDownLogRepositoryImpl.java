package com.example.tea.admin.server.content.dao.persist.repository.impl;

import com.example.tea.admin.server.content.dao.persist.mapper.UpDownLogMapper;
import com.example.tea.admin.server.content.dao.persist.repository.IUpDownLogRepository;
import com.example.tea.admin.server.content.pojo.entity.UpDownLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @className UpDownLogRepositoryImpl
 * @date 2023/06/14 18:27
 */
@Slf4j
@Repository
public class UpDownLogRepositoryImpl implements IUpDownLogRepository {
    @Resource
    UpDownLogMapper upDownLogMapper;

    public UpDownLogRepositoryImpl() {
        log.info("创建存储库对象: UpDownLogRepositoryImpl");
    }
    
    @Override
    public int insert(UpDownLog upDownLog) {
        log.debug("开始执行向【内容-顶踩历史表】中插入数据: {}", upDownLog);
        
        return upDownLogMapper.insert(upDownLog);
    }
}
