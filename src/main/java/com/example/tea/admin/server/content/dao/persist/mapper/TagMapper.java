package com.example.tea.admin.server.content.dao.persist.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tea.admin.server.content.pojo.entity.Tag;
import com.example.tea.admin.server.content.pojo.vo.TagListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagStandardVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 1.0
 * @date 2023/06/13 11:57
 */
@Repository
public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 根据ID查询标签
     * @param id 标签ID
     * @return 标签数据
     */
    TagStandardVO getStandardById(Long id);

    /**
     * 根据ID查询标签类别
     * @param id 标签类别ID
     * @return 标签类别数据
     */
    TagTypeStandardVO getStandardTypeById(Long id);

    /**
     * 查询标签列表
     * @return 标签数据集合
     */
    List<TagListItemVO> list();

    /**
     * 查询标签分类列表
     * @return 标签类别数据集合
     */
    List<TagTypeListItemVO> listTgaType();
}
