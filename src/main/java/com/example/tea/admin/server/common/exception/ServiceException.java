package com.example.tea.admin.server.common.exception;

import com.example.tea.admin.server.common.web.ServiceCode;
import lombok.Getter;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @className ServiceException
 * @date 2023/06/14 16:45
 */
public class ServiceException extends RuntimeException {
    @Getter
    private final ServiceCode serviceCode;
    
    public ServiceException(ServiceCode serviceCode, String message) {
        super(message);
        this.serviceCode = serviceCode;
    }
}
