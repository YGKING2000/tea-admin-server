package com.example.tea.admin.server.account.dao.persist.mapper;

import com.example.tea.admin.server.account.pojo.entity.User;
import com.example.tea.admin.server.account.pojo.vo.UserLoginInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/21 09:33
 */
@SpringBootTest
public class UserMapperTests {
    @Resource
    private UserMapper mapper;
    
    @Test
    void getLoginInfoByUsername() {
        String username = "root";
        UserLoginInfoVO result = mapper.getLoginInfoByUsername(username);
        System.out.println("数据查询成功: " + result);        
    }
    
    @Test
    void insertBatch() {
        ArrayList<User> list = new ArrayList<>();
        for (int i = 4500000; i < 5000000; i++) {
            User user = new User();
            user.setUsername("user-" + i);
            list.add(user);
        }
        long start = System.currentTimeMillis();
        mapper.insertBatch(list);
        long end = System.currentTimeMillis();
        System.out.println("本次测试耗时: " + (end - start));        
    }
}
