package com.example.tea.admin.server.account.dao.cache;

import com.example.tea.admin.server.account.pojo.po.UserLoginInfoPO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/03 10:20
 */
@SpringBootTest
public class UserCacheRepositoryTests {
    @Resource
    private IUserCacheRepository repository;
    
    @Test
    void saveLoginInfo() {
        UserLoginInfoPO userLoginInfoPO = new UserLoginInfoPO();
        userLoginInfoPO.setIp("333");
        userLoginInfoPO.setUserAgent("7777777");
        userLoginInfoPO.setAuthoritiesJsonString("999999999");
        
        String jwt = "379";
        
        repository.saveLoginInfo(jwt, userLoginInfoPO);
        System.out.println("数据存储成功!");
    }
}
