package com.example.tea.admin.server;

import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;

// @SpringBootTest
class TeaAdminServerApplicationTests {
    @Test
    @Sql(scripts = {"classpath:/teacher_sql/truncate_table.sql", "classpath:/teacher_sql/insert_data.sql"})
    void insertTestData() {
        System.out.println("运行完成!");
    }
}
