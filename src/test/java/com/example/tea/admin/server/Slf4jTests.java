package com.example.tea.admin.server;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @description
 * @className Slf4jTests
 * @date 2023/06/14 09:42
 */
@Slf4j
public class Slf4jTests {
    @Test
    void test() {
        log.trace("跟踪");
        log.debug("调试");
        log.info("一般");
        log.warn("警告");
        log.error("错误");

        int x = 1, y = 2;
        log.debug("x = {}, y = {}, x + y = {}", x, y, x + y);
        System.out.printf("x = %d, y = %d, x + y = %d", x, y, x + y);
    }
    
}
