package com.example.tea.admin.server;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/25 14:42
 */
public class JwtTests {
    @Test
    void generate() {
        String secretKey = "YouDontTellMeWhatDirectionYouThinkIShouldTake!";

        // Claims类继承自Map<String, Object>接口
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 9527);
        claims.put("username", "huge");

        Date date = new Date(System.currentTimeMillis() + 365L * 24 * 60 * 60 * 1000);
        // Date date = new Date(System.currentTimeMillis());
        // 注意在第一个数后加上L，避免超过int的表示范围
        String jwt = Jwts.builder()
                // Header 头部
                .setHeaderParam("alg", "HS256")// 验证方式
                .setHeaderParam("typ", "JWT")
                // Payload 载荷
                .setClaims(claims)// 存储的信息 
                .setExpiration(date)// Jwt过期的时间
                // Verify Signature 签名验证 
                // 注意事项: 验证方式应该和头部中的验证方式一致
                .signWith(SignatureAlgorithm.HS256, secretKey)// 验证方式+签名
                // Done 完成
                .compact();
        System.out.println(jwt);
    }

    // JWT过期的异常: io.jsonwebtoken.ExpiredJwtException
    // JWT格式错误的异常: io.jsonwebtoken.SignatureException
    // JWT解析后的(我们存储的数据(body部分解析出来后有乱码))的格式错误异常: io.jsonwebtoken.MalformedJwtException

    @Test
    void parse() {
        String jwt = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiYXZhdGFyIjoiaHR0cHM6Ly9pbWcxLmJhaWR1LmNvbS9pdC91PTE3MjAzMzc1NywyMzk4MjkwNzY3JmZtPTI1MyZmbXQ9YXV0byZhcHA9MTM4JmY9SlBFRz93PTUwMCZoPTUwMCIsImV4cCI6MTY5MDI3NjY0NSwiYXV0aG9yaXRpZXNTdHJpbmciOiJbe1wiYXV0aG9yaXR5XCI6XCIvYWNjb3VudC91c2VyL2FkZC1uZXdcIn0se1wiYXV0aG9yaXR5XCI6XCIvYWNjb3VudC91c2VyL2RlbGV0ZVwifSx7XCJhdXRob3JpdHlcIjpcIi9hY2NvdW50L3VzZXIvcmVhZFwifSx7XCJhdXRob3JpdHlcIjpcIi9hY2NvdW50L3VzZXIvdXBkYXRlXCJ9LHtcImF1dGhvcml0eVwiOlwiL2NvbnRlbnQvY2F0ZWdvcnkvYWRkLW5ld1wifSx7XCJhdXRob3JpdHlcIjpcIi9jb250ZW50L2NhdGVnb3J5L2RlbGV0ZVwifSx7XCJhdXRob3JpdHlcIjpcIi9jb250ZW50L2NhdGVnb3J5L3JlYWRcIn0se1wiYXV0aG9yaXR5XCI6XCIvY29udGVudC9jYXRlZ29yeS91cGRhdGVcIn0se1wiYXV0aG9yaXR5XCI6XCIvY29udGVudC90YWcvYWRkLW5ld1wifSx7XCJhdXRob3JpdHlcIjpcIi9jb250ZW50L3RhZy9kZWxldGVcIn0se1wiYXV0aG9yaXR5XCI6XCIvY29udGVudC90YWcvcmVhZFwifSx7XCJhdXRob3JpdHlcIjpcIi9jb250ZW50L3RhZy91cGRhdGVcIn1dIiwidXNlcm5hbWUiOiJyb290In0.H7P1DbiMuIo8ILXHJOKFapG8OLsukU2UmE5b1O2z3ss";
        String secretKey = "YouDontTellMeWhatDirectionYouThinkIShouldTake!";
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();

        Long id = claims.get("id", Long.class);
        String username = claims.get("username", String.class);
        String avatar = claims.get("avatar", String.class);

        String authoritiesJsonString = claims.get("authoritiesJsonString", String.class);
        List<SimpleGrantedAuthority> authorities = JSON.parseArray(authoritiesJsonString, SimpleGrantedAuthority.class);

        System.out.println("id: " + id);
        System.out.println("username: " + username);
        System.out.println(avatar);

        for (SimpleGrantedAuthority authority : authorities) {
            System.out.println(authority);
        }
    }
}
