package com.example.tea.admin.server.core.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @className ValidationConfiguration
 * @date 2023/06/15 16:42
 */
@Slf4j
@Configuration
public class ValidationConfiguration {

    public ValidationConfiguration() {
        log.debug("创建配置类对象: ValidationConfiguration");
    }

    @Bean
    public javax.validation.Validator validator() {
        return Validation.byProvider(HibernateValidator.class)
                .configure() // 开始配置
                .failFast(true) // 配置快速失败
                .buildValidatorFactory() // 构建Validator工厂
                .getValidator(); // 从Validator工厂中获取Validator对象
    }

}
