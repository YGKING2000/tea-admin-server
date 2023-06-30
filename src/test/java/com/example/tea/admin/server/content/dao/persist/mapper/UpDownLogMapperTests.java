package com.example.tea.admin.server.content.dao.persist.mapper;

import com.example.tea.admin.server.content.pojo.entity.UpDownLog;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @description
 * @className ArticleDetailMapperTests
 * @date 2023/06/13 20:49
 */
@SpringBootTest
public class UpDownLogMapperTests {
    @Resource
    UpDownLogMapper mapper;
    
    @Test
    void insert() {
        UpDownLog upDownLog = new UpDownLog();
        upDownLog.setUserId(1L);
        upDownLog.setResourceType(1);
        upDownLog.setResourceId(1L);
        upDownLog.setOpType(1);
        int rows = mapper.insert(upDownLog);
        System.out.println("插入数据成功，影响行数为:" + rows);
    }
    
    @Test
    void getStandardById() {
        System.out.println(mapper.getStandardById(2L));
    }
}
