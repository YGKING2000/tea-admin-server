package com.example.tea.admin.server.content.dao.persist.repository;

import com.example.tea.admin.server.content.pojo.entity.UpDownLog;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @description
 * @className UpDownLogRepositoryTests
 * @date 2023/06/14 14:28
 */
@SpringBootTest
public class UpDownLogRepositoryTests {
    @Resource
    IUpDownLogRepository repository;

    @Test
    @Sql(value = "classpath:/sql/truncate_table.sql")
    @Sql(scripts = "classpath:/sql/truncate_table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void insert() {
        UpDownLog upDownLog = new UpDownLog();
        upDownLog.setUserId(3L);
        upDownLog.setOpType(2);
        upDownLog.setResourceId(7L);
        upDownLog.setResourceType(4);
        repository.insert(upDownLog);
        System.out.println(upDownLog);
    }
}
