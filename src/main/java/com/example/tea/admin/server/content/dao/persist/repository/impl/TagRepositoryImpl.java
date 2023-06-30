package com.example.tea.admin.server.content.dao.persist.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.common.util.PageInfoToPageDataConverter;
import com.example.tea.admin.server.content.dao.persist.mapper.TagMapper;
import com.example.tea.admin.server.content.dao.persist.repository.ITagRepository;
import com.example.tea.admin.server.content.pojo.entity.Tag;
import com.example.tea.admin.server.content.pojo.vo.TagListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagStandardVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeStandardVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @className TagRepositoryImpl
 * @date 2023/06/14 14:23
 */
@Slf4j
@Repository
public class TagRepositoryImpl implements ITagRepository {
    @Resource
    TagMapper tagMapper;

    public TagRepositoryImpl() {
         
    }
    
    @Override
    public int insert(Tag tag) {
        log.debug("开始向【内容-标签表】中插入数据: {}", tag);
        return tagMapper.insert(tag);
    }

    @Override
    public int deleteById(Long id) {
        log.debug("开始执行【根据ID({})删除】内容-标签表中的数据", id);
        return tagMapper.deleteById(id);
    }

    @Override
    public int deleteByParentId(Long parentId) {
        log.debug("开始执行【根据parentId({})删除】内容-标签表中的数据", parentId);
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", parentId);
        return tagMapper.delete(wrapper);
    }

    @Override
    public int updateById(Tag tag) {
        log.debug("开始执行【根据ID({})修改】内容-标签表中的数据", tag);
        return tagMapper.updateById(tag);
    }

    @Override
    public int updateEnableByParentId(Long parentId, Integer enable) {
        log.debug("开始执行【根据parentId({})修改】内容-标签表中的数据状态值为: {}", parentId, enable);
        Tag tag = new Tag();
        tag.setEnable(enable);
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", parentId);
        return tagMapper.update(tag, wrapper);
    }

    @Override
    public int countByName(String name) {
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        Integer count = tagMapper.selectCount(wrapper);
        
        log.debug("开始执行【根据名称name({})统计】内容-标签表中数量为: {}", name, count);
        return count;
    }

    @Override
    public int countByNameAndNotId(String name, Long id) {
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name).ne("id", id);
        Integer count = tagMapper.selectCount(wrapper);

        log.debug("开始执行【根据名称name({})和ID不等于({})统计】内容-标签表中数量为: {}", name, id, count);
        return count;
    }

    @Override
    public TagStandardVO getStandardById(Long id) {
        log.debug("开始执行【根据ID({})查询数据】", id);
        return tagMapper.getStandardById(id);
    }

    @Override
    public TagTypeStandardVO getStandardTypeById(Long id) {
        log.debug("开始执行【根据ID({})查询数据】", id);
        return tagMapper.getStandardTypeById(id);
    }

    @Override
    public PageData<TagTypeListItemVO> listTgaType(Integer pageNum, Integer pageSize) {
        log.debug("开始执行【查询标签类别列表】，页码: {}, 每页记录数: {}", pageNum, pageSize);
        
        PageHelper.startPage(pageNum, pageSize);
        List<TagTypeListItemVO> list = tagMapper.listTgaType();
        
        PageInfo<TagTypeListItemVO> pageInfo = new PageInfo<>(list);
        return PageInfoToPageDataConverter.convert(pageInfo);
    }

    @Override
    public PageData<TagListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始执行【查询标签类别列表】，页码: {}, 每页记录数: {}", pageNum, pageSize);

        PageHelper.startPage(pageNum, pageSize);
        List<TagListItemVO> list = tagMapper.list();

        PageInfo<TagListItemVO> pageInfo = new PageInfo<>(list);
        return PageInfoToPageDataConverter.convert(pageInfo);
    }
}
