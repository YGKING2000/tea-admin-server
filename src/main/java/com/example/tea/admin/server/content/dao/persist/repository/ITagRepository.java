package com.example.tea.admin.server.content.dao.persist.repository;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.content.pojo.entity.Tag;
import com.example.tea.admin.server.content.pojo.vo.TagListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagStandardVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeStandardVO;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 1.0
 * @date 2023/06/14 14:08
 */
public interface ITagRepository {

    /**
     * 向【内容-标签表】插入一条数据
     * @param tag 标签实体类对象
     * @return 表中被影响的行数
     */
    int insert(Tag tag);

    /**
     * 根据ID删除一条数据
     * @param id 被删除数据的ID
     * @return 表中受影响的行数
     */
    int deleteById(Long id);

    /**
     * 根据parentId删除数据
     * @param id 被删除数据的parentId
     * @return 表中受影响的行数
     */
    int deleteByParentId(Long parentId);

    /**
     * 根据ID修改一条数据
     * @param tag 被修改数据ID和新修改的数据
     * @return 表中受影响的行数
     */
    int updateById(Tag tag);

    /**
     * 根据父级ID修改状态值
     * @param parentId 父级ID
     * @param enable 标签状态值
     * @return 表中受影响的行数
     */
    int updateEnableByParentId(Long parentId, Integer enable);

    /**
     * 根据标签类别名称统计记录数
     * @param name 标签类别名称
     * @return 统计记录数
     */
    int countByName(String name);

    /**
     * 根据标签名称和ID不等于给定值统计记录数
     * @param name 标签名称
     * @param id 标签ID
     * @return 统计记录数
     */
    int countByNameAndNotId(String name, Long id);

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
     * 查询标签类别列表
     * @param pageNum 页码
     * @param pageSize 每页记录数
     * @return 标签类别列表
     */
    PageData<TagTypeListItemVO> listTgaType(Integer pageNum, Integer pageSize);

    /**
     * 查询标签列表
     * @param pageNum 页码
     * @param pageSize 每页记录数
     * @return 标签类别列表
     */
    PageData<TagListItemVO> list(Integer pageNum, Integer pageSize);
}
