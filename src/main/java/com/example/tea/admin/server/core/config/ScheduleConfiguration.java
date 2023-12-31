package com.example.tea.admin.server.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/06 15:05
 */
@Slf4j
@Configuration
@EnableScheduling
public class ScheduleConfiguration {
    public ScheduleConfiguration() {
        log.debug("创建配置类对象: ScheduleConfiguration");
    }
}
