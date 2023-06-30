package com.example.tea.admin.server.content.dao.persist.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tea.admin.server.content.pojo.entity.UpDownLog;
import com.example.tea.admin.server.content.pojo.vo.UpDownLogStandardVO;
import org.springframework.stereotype.Repository;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 1.0
 * @date 2023/06/13 21:01
 */
@Repository
public interface UpDownLogMapper extends BaseMapper<UpDownLog> {
    UpDownLogStandardVO getStandardById(Long id);
}
