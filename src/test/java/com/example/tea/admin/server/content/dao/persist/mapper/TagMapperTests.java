package com.example.tea.admin.server.content.dao.persist.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tea.admin.server.content.pojo.entity.Tag;
import com.example.tea.admin.server.content.pojo.vo.TagStandardVO;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @description
 * @className TagMapperTests
 * @date 2023/06/13 11:59
 */
@SpringBootTest
public class TagMapperTests {
    @Resource
    TagMapper mapper;

    @Test
    @Sql(value = "classpath:/sql/truncate_table.sql")
    void insert() {
        Tag tag = new Tag();
        tag.setName("测试添加内容标签");
        mapper.insert(tag);
        System.out.println(tag);
    }

    @Test
    @Sql("classpath:/sql/insert_data.sql")
    void deleteById() {
        int rows = mapper.deleteById(10);
        System.out.println("删除成功，受影响的行数为:" + rows);
    }
    
    @Test
    void deleteByMap() {
        HashMap<String , Object> map = new HashMap<>();
        map.put("id", 3);
        map.put("sort", 1);
        int rows = mapper.deleteByMap(map);
        System.out.println("删除成功，受影响的行数为:" + rows);
    }
    
    @Test
    void delete() {
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 2);
        wrapper.eq("sort", 1);
        // wrapper.eq("id", 4);
        int rows = mapper.delete(wrapper);
        System.out.println("删除成功，受影响的行数为:" + rows);
    }
    
    @Test
    void deleteBatchIds() {
        ArrayList<Long> idList = new ArrayList<>();
        idList.add(2L);
        idList.add(6L);
        idList.add(7L);
        int rows = mapper.deleteBatchIds(idList);
        System.out.println("删除成功，受影响的行数为:" + rows);
    }

    @Test
    @Sql("classpath:/sql/insert_data.sql")
    void updateById() {
        Tag tag = new Tag();
        tag.setId(1L);
        tag.setSort(199);
        tag.setEnable(1);
        int rows = mapper.updateById(tag);
        System.out.println("修改成功，受影响的行数为:" + rows);
    }
    
    @Test
    void update() {
        Tag tag = new Tag();
        tag.setSort(77);
        tag.setEnable(1);

        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 13);

        int rows = mapper.update(tag, wrapper);
        System.out.println("修改成功，受影响的行数为:" + rows);
    }
    
    @Test
    void selectCount() {
        Integer count = mapper.selectCount(null);
        System.out.println("统计数据成功，统计结果:" + count);
    }
    
    @Test
    void selectCountByName() {
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "GGG");
        Integer count = mapper.selectCount(wrapper);
        System.out.println("统计数据成功，统计结果:" + count);
    }

    @Test
    @Sql(value = "classpath:/sql/insert_data.sql")
    void getStandardById() {
        TagStandardVO result = mapper.getStandardById(1L);
        System.out.println(result);
    }

    @Test
    // @Sql(value = "classpath:/sql/insert_data.sql") 
    // @Sql(value = "classpath:/sql/truncate_table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void listTgaType() {
        List<?> list = mapper.listTgaType();
        System.out.println("【内容-标签表】中的分类数量为: " + list.size());
        for (Object item : list) {
            System.out.println("列表项: " + item);
        }
    }

    @Test
    // @Sql(value = "classpath:/sql/insert_data.sql") 
    // @Sql(value = "classpath:/sql/truncate_table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void list() {
        List<?> list = mapper.list();
        System.out.println("【内容-标签表】中的标签数量为: " + list.size());
        for (Object item : list) {
            System.out.println("列表项: " + item);
        }
    }
}
