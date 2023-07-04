package com.example.tea.admin.server.account.dao.cache;

import com.example.tea.admin.server.account.pojo.po.UserLoginInfoPO;
import com.example.tea.admin.server.common.consts.UserCacheConsts;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/03 10:15
 */
public interface IUserCacheRepository extends UserCacheConsts {
    void saveLoginInfo(String jwt, UserLoginInfoPO userLoginInfoPO);
    
    void saveEnableByUserId(Long userId, Integer enable);
    
    UserLoginInfoPO getLoginInfo(String jwt);
    
    Integer getEnableByUserId(Long userId);
}
