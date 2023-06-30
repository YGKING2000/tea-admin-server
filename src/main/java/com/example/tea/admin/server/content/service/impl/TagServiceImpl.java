package com.example.tea.admin.server.content.service.impl;

import com.example.tea.admin.server.common.exception.ServiceException;
import com.example.tea.admin.server.common.pojo.vo.PageData;
import com.example.tea.admin.server.common.web.ServiceCode;
import com.example.tea.admin.server.content.dao.persist.repository.ITagRepository;
import com.example.tea.admin.server.content.pojo.entity.Tag;
import com.example.tea.admin.server.content.pojo.param.TagAddNewParam;
import com.example.tea.admin.server.content.pojo.param.TagTypeAddNewParam;
import com.example.tea.admin.server.content.pojo.param.TagTypeUpdateInfoParam;
import com.example.tea.admin.server.content.pojo.param.TagUpdateInfoParam;
import com.example.tea.admin.server.content.pojo.vo.TagListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagStandardVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeListItemVO;
import com.example.tea.admin.server.content.pojo.vo.TagTypeStandardVO;
import com.example.tea.admin.server.content.service.ITagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 1.0
 * @className TagServiceImpl
 * @date 2023/06/14 14:55
 */
@Slf4j
@Service
public class TagServiceImpl implements ITagService {
    @Resource
    private ITagRepository tagRepository;

    @Value("${tea-store.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;

    public TagServiceImpl() {
        log.info("创建业务对象: TagServiceImpl");
    }

    @Override
    public void addNew(TagTypeAddNewParam tagTypeAddNewParam) {
        log.debug("开始处理【新增标签类别】业务，参数: {}", tagTypeAddNewParam);

        String name = tagTypeAddNewParam.getName();
        int count = tagRepository.countByName(name);
        if (count > 0) {
            String message = "新增标签类别失败，标签名称已存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Tag tag = new Tag();
        BeanUtils.copyProperties(tagTypeAddNewParam, tag);
        tag.setParentId(0L);
        int rows = tagRepository.insert(tag);
        if (rows != 1) {
            String message = "新增标签类别失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_INSERT, message);
        }
    }

    @Override
    public void addNew(TagAddNewParam tagAddNewParam) {
        log.debug("开始处理【新增标签】业务，参数: {}", tagAddNewParam);

        String name = tagAddNewParam.getName();
        int count = tagRepository.countByName(name);
        if (count > 0) {
            String message = "新增标签失败，标签名称已存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Tag tag = new Tag();
        BeanUtils.copyProperties(tagAddNewParam, tag);
        int rows = tagRepository.insert(tag);
        if (rows != 1) {
            String message = "新增标签失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_INSERT, message);
        }
    }

    @Override
    public void delete(Long id) {
        log.debug("开始处理【根据ID删除标签】业务，参数: {}", id);
        TagStandardVO tagStandardVO = tagRepository.getStandardById(id);
        if (tagStandardVO == null || tagStandardVO.getTypeId() == 0) {
            String message = "删除标签失败，尝试删除的标签不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        
        int rows = tagRepository.deleteById(id);
        if (rows != 1) {
            String message = "删除标签失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_DELETE, message);
        }
    }

    @Override
    public void deleteType(Long id) {
        log.debug("开始处理【根据ID删除标签类别】业务，参数: {}", id);
        TagStandardVO tagStandardVO = tagRepository.getStandardById(id);
        if (tagStandardVO == null || tagStandardVO.getTypeId() != 0) {
            String message = "删除标签类别失败，尝试删除的标签类别不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        int rows = tagRepository.deleteById(id);
        if (rows != 1) {
            String message = "删除标签类别失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_DELETE, message);
        }

        rows = tagRepository.deleteByParentId(id);
        if (rows < 1) {
            String message = "删除标签类别的子标签失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_DELETE, message);
        }
    }

    @Override
    public void updateInfoById(TagUpdateInfoParam tagUpdateInfoParam) {
        log.debug("开始处理【根据ID修改标签】业务，参数: {}", tagUpdateInfoParam);

        Long id = tagUpdateInfoParam.getId();
        TagStandardVO currentTag = tagRepository.getStandardById(id);
        if (currentTag == null || currentTag.getTypeId() == 0) {
            String message = "修改标签失败，尝试修改的标签不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        String name = tagUpdateInfoParam.getName();
        int count = tagRepository.countByNameAndNotId(name, id);
        if (count > 0) {
            String message = "修改标签失败，该标签名称已存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Tag tag = new Tag();
        BeanUtils.copyProperties(tagUpdateInfoParam, tag);
        tag.setParentId(tagUpdateInfoParam.getTypeId());
        int rows = tagRepository.updateById(tag);
        if (rows != 1) {
            String message = "修改标签失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }

    @Override
    public void updateTypeInfoById(TagTypeUpdateInfoParam tagTypeUpdateInfoParam) {
        log.debug("开始处理【根据ID修改标签类别】业务，参数: {}", tagTypeUpdateInfoParam);

        Long id = tagTypeUpdateInfoParam.getId();
        TagTypeStandardVO currentTagType = tagRepository.getStandardTypeById(id);
        if (currentTagType == null || currentTagType.getTypeId() != 0) {
            String message = "修改标签类别失败，尝试修改的标签类别不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        String name = tagTypeUpdateInfoParam.getName();
        int count = tagRepository.countByNameAndNotId(name, id);
        if (count > 0) {
            String message = "修改标签类别失败，该标签类别名称已存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Tag tag = new Tag();
        BeanUtils.copyProperties(tagTypeUpdateInfoParam, tag);
        int rows = tagRepository.updateById(tag);
        if (rows != 1) {
            String message = "修改标签类别失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }

    @Override
    public void setEnable(Long id) {
        log.debug("开始处理【根据ID启用标签状态】业务，参数: {}", id);
        updateEnableById(id, 1);
    }

    @Override
    public void setTypeEnable(Long id) {
        log.debug("开始处理【根据ID启用标签类别状态】业务，参数: {}", id);
        updateTypeEnableById(id, 1);
    }

    @Override
    public void setDisable(Long id) {
        log.debug("开始处理【根据ID禁用标签状态】业务，参数: {}", id);
        updateEnableById(id, 0);
    }

    @Override
    public void setTypeDisable(Long id) {
        log.debug("开始处理【根据ID禁用标签类别状态】业务，参数: {}", id);
        updateTypeEnableById(id, 0);
    }

    @Override
    public TagStandardVO getStandardById(Long id) {
        log.debug("开始处理【根据ID查询标签】业务，参数: {}", id);
        TagStandardVO tagStandardVO = tagRepository.getStandardById(id);
        if (tagStandardVO == null || tagStandardVO.getTypeId() == 0) {
            String message = "获取标签详情失败，尝试访问的标签不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        return tagStandardVO;
    }

    @Override
    public TagTypeStandardVO getStandardTypeById(Long id) {
        log.debug("开始处理【根据ID查询标签类别】业务，参数: {}", id);
        TagTypeStandardVO tagTypeStandardVO = tagRepository.getStandardTypeById(id);
        if (tagTypeStandardVO == null || tagTypeStandardVO.getTypeId() != 0) {
            String message = "获取标签类别详情失败，尝试访问的标签类别不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        return tagTypeStandardVO;
    }

    @Override
    public PageData<TagTypeListItemVO> listTgaType(Integer pageNum) {
        log.debug("开始处理【查询标签类别列表】业务，页码: {}", pageNum);
        return tagRepository.listTgaType(pageNum, defaultQueryPageSize);
    }

    @Override
    public PageData<TagTypeListItemVO> listTgaType(Integer pageNum, Integer pageSize) {
        log.debug("开始处理【查询标签类别列表】业务，页码: {}, 每天记录数: {}", pageNum, pageSize);
        return tagRepository.listTgaType(pageNum, pageSize);
    }

    @Override
    public PageData<TagListItemVO> list(Integer pageNum) {
        log.debug("开始处理【查询标签列表】业务，页码: {}", pageNum);
        return tagRepository.list(pageNum, defaultQueryPageSize);
    }

    @Override
    public PageData<TagListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始处理【查询标签列表】业务，页码: {}, 每条记录数: {}", pageNum, pageSize);
        return tagRepository.list(pageNum, pageSize);
    }

    private void updateEnableById(Long id, Integer enable) {
        TagStandardVO currentTag = tagRepository.getStandardById(id);
        if (currentTag == null || currentTag.getTypeId() == 0) {
            String message = ENABLE_TEXT[enable] + "标签失败，尝试" + ENABLE_TEXT[enable] + "的标签不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        
        if (currentTag.getEnable().equals(enable)) {
            String message = ENABLE_TEXT[enable] + "标签失败，当前标签已处于" + ENABLE_TEXT[enable] + "状态";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Tag tag = new Tag();
        tag.setId(id);
        tag.setEnable(enable);
        int rows = tagRepository.updateById(tag);
        if (rows != 1) {
            String message = ENABLE_TEXT[enable] + "标签失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }

    private void updateTypeEnableById(Long id, Integer enable) {
        TagStandardVO currentTag = tagRepository.getStandardById(id);
        if (currentTag == null || currentTag.getTypeId() != 0) {
            String message = ENABLE_TEXT[enable] + "标签类别失败，尝试" + ENABLE_TEXT[enable] + "的标签类别不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        if (currentTag.getEnable().equals(enable)) {
            String message = ENABLE_TEXT[enable] + "标签类别失败，当前标签类别已处于" + ENABLE_TEXT[enable] + "状态";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Tag tag = new Tag();
        tag.setId(id);
        tag.setEnable(enable);
        int rows = tagRepository.updateById(tag);
        if (rows != 1) {
            String message = ENABLE_TEXT[enable] + "标签类别失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }

        rows = tagRepository.updateEnableByParentId(id, enable);
        if (rows < 0) {
            String message = ENABLE_TEXT[enable] + "标签失败，服务器忙，请稍后再试!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }
}
