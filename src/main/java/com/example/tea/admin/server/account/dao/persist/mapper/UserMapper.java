package com.example.tea.admin.server.account.dao.persist.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tea.admin.server.account.pojo.entity.User;
import com.example.tea.admin.server.account.pojo.vo.UserListItemVO;
import com.example.tea.admin.server.account.pojo.vo.UserLoginInfoVO;
import com.example.tea.admin.server.account.pojo.vo.UserStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/21 09:18
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 批量插入用户数据
     *
     * @param userList 若干个用户数据的集合
     * @return 受影响的行数
     */
    int insertBatch(List<User> userList);

    /**
     * 统计用户数据的数量
     *
     * @return 用户数据的数量
     */
    int count();

    /**
     * 根据用户名统计用户数据的数量
     *
     * @param username 用户名
     * @return 匹配用户名的用户数据的数据
     */
    int countByUsername(String username);

    /**
     * 根据手机号码统计用户数据的数量
     *
     * @param phone 手机号码
     * @return 匹配手机号码的用户数据的数据
     */
    int countByPhone(String phone);

    /**
     * 根据电子邮箱统计用户数据的数量
     *
     * @param email 电子邮箱
     * @return 匹配电子邮箱的用户数据的数据
     */
    int countByEmail(String email);

    /**
     * 根据用户ID查询用户数据详情
     *
     * @param id 用户ID
     * @return 匹配的用户数据详情，如果没有匹配的数据，则返回null
     */
    UserStandardVO getStandardById(Long id);

    /**
     * 根据用户名查询用户的登录信息
     *
     * @param username 用户名
     * @return 匹配的用户的登录信息，如果没有匹配的数据，则返回null
     */
    UserLoginInfoVO getLoginInfoByUsername(String username);

    /**
     * 查询用户数据列表
     *
     * @return 用户数据列表
     */
    List<UserListItemVO> list();
}
