package com.example.tea.admin.server;

import com.example.tea.admin.server.content.dao.persist.mapper.TagMapper;
import com.example.tea.admin.server.content.pojo.vo.TagListItemVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @className PageHelperTests
 * @date 2023/06/17 10:28
 */
@SpringBootTest
public class PageHelperTests {
    @Resource
    TagMapper mapper;
    
    @Test
    void pageHelperTest() {
        PageHelper.startPage(1, 3);
        List<?> list = mapper.listTgaType();
        System.out.println("【内容-标签表】中的分类数量为: " + list.size());
        System.out.println("列表查询成功，列表类型为: " + list.getClass().getName());
        System.out.println(list);
        for (Object item : list) {
            System.out.println("列表项: " + item);
        }

        System.out.println();
        PageInfo<?> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
    }
}
