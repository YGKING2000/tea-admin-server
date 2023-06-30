package com.example.tea.admin.server.resource.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/** 
 * 文件上传返回结果VO类
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/27 09:54
 */
@Data
@Accessors(chain = true)
public class UploadResultVO {
    /**
     * 文件URL
     */
    private String url;
    /**
     * 文件大小
     */
    private Long fileSize;
    /**
     * 文档MIME类型
     */
    private String contentType;
    /**
     * 文件名
     */
    private String fileName;
}
