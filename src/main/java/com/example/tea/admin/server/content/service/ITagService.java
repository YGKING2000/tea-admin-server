package com.example.tea.admin.server.content.service;

import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.content.pojo.param.TagAddNewParam;
import com.example.tea.admin.server.content.pojo.param.TagTypeAddNewParam;
import com.example.tea.admin.server.content.pojo.param.TagTypeUpdateInfoParam;
import com.example.tea.admin.server.content.pojo.param.TagUpdateInfoParam;
import com.example.tea.admin.server.content.pojo.vo.TagListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagStandardVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeStandardVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/14 14:52
 */
@Transactional
public interface ITagService {
    String[] ENABLE_TEXT = {"禁用", "启用"};
    
    /**
     *  新增标签类别
     * @param tagTypeAddNewParam 新增标签类别参数
     */
    void addNew(TagTypeAddNewParam tagTypeAddNewParam);

    /**
     *  新增标签
     * @param tagAddNewParam 新增标签参数
     */
    void addNew(TagAddNewParam tagAddNewParam);

    /**
     * 根据ID删除标签
     * @param id 被删除数据的ID
     */
    void delete(Long id);

    /**
     * 根据ID删除标签类别
     * @param id 被删除数据的ID
     */
    void deleteType(Long id);

    /**
     * 根据ID修改标签
     * @param tagUpdateInfoParam 被修改数据ID和新修改的数据
     */
    void updateInfoById(TagUpdateInfoParam tagUpdateInfoParam);

    /**
     * 根据ID修改标签类别
     * @param tagTypeUpdateInfoParam 被修改数据ID和新修改的数据
     */
    void updateTypeInfoById(TagTypeUpdateInfoParam tagTypeUpdateInfoParam);

    /**
     * 启用标签
     * @param id 被启用标签数据ID
     */
    void setEnable(Long id);

    /**
     * 启用标签类别
     * @param id 被启用标签类别数据ID
     */
    void setTypeEnable(Long id);

    /**
     * 禁用标签
     * @param id 被禁用标签数据ID
     */
    void setDisable(Long id);

    /**
     * 禁用标签类别
     * @param id 被禁用标签类别数据ID
     */
    void setTypeDisable(Long id);

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
     * 查询标签类别列表 使用默认每页记录数
     * @param pageNum 页码
     * @return 标签类别列表
     */
    PageData<TagTypeListItemVO> listTgaType(Integer pageNum);

    /**
     * 查询标签类别列表
     * @param pageNum 页码
     * @param pageSize 每页记录数
     * @return 标签类别列表
     */
    PageData<TagTypeListItemVO> listTgaType(Integer pageNum, Integer pageSize);

    /**
     * 查询标签列表 使用默认每页记录数
     * @param pageNum 页码
     * @return 标签列表
     */
    PageData<TagListItemVO> list(Integer pageNum);

    /**
     * 查询标签列表
     * @param pageNum 页码
     * @param pageSize 每页记录数
     * @return 标签列表
     */
    PageData<TagListItemVO> list(Integer pageNum, Integer pageSize);
}
