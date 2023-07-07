package com.example.tea.admin.server.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @className MybatisConfiguration
 * @date 2023/06/13 11:56
 */
@Configuration
@MapperScan({
        "com.example.tea.admin.server.*.dao.persist.mapper"
})
public class MybatisConfiguration {
}
