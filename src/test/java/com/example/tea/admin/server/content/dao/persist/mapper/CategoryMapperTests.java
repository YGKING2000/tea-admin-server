package com.example.tea.admin.server.content.dao.persist.mapper;

import com.example.tea.admin.server.content.pojo.entity.Category;
import com.example.tea.admin.server.content.pojo.vo.CategoryStandardVO;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @description
 * @className CategoryMapperTests
 * @date 2023/06/13 19:01
 */
@SpringBootTest
public class CategoryMapperTests {
    @Resource
    CategoryMapper mapper;
    
    @Test
    void insert() {
        Category category = new Category();
        category.setName("炒茶视频");
        category.setKeywords("20年陈年老茶");
        int rows = mapper.insert(category);
        System.out.println("插入成功，影响行数为:" + rows);
    }
    
    @Test
    void getStandardById() {
        System.out.println(mapper.getStandardById(2L));
    }
}
