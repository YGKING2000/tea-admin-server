package com.example.tea.admin.server;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/20 17:57
 */
public class PasswordEncoder {
    @Test
    void bCryptEncode() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String[] passwords = {"123456", "123456", "123456"};
        for (int i = 0; i < 3; i++) {
            System.out.println(encoder.encode(passwords[i]));
        }
    }

    @Test
    void md5Encode() {
        String[] passwords = {"123456", "123456", "123456"};
        for (int i = 0; i < 3; i++) {
            System.out.println(DigestUtils.md5DigestAsHex(passwords[i].getBytes()));
        }
    }
}
