package com.example.tea.admin.server.account.dao.persist.repository;

import com.example.tea.admin.server.account.pojo.vo.UserLoginInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/21 09:44
 */
@SpringBootTest
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"})
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UserRepositoryTests {
    @Resource
    private IUserRepository repository;

    @Test
    void getLoginInfoByUsername() {
        String username = "root";
        UserLoginInfoVO result = repository.getLoginInfoByUsername(username);
        System.out.println("数据查询成功: " + result);
    }
}
