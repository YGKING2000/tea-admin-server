package com.example.tea.admin.server.resource.controller;

import com.example.tea.admin.server.common.exception.ServiceException;
import com.example.tea.admin.server.common.web.JsonResult;
import com.example.tea.admin.server.common.web.ServiceCode;
import com.example.tea.admin.server.resource.pojo.vo.UploadResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 处理文件上传的控制器类
 *
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/27 09:53
 */
@Slf4j
@RestController
@Api(tags = "4.1 文件上传模块")
@RequestMapping("/resources")
public class ResourceController {

    @Value("${tea-store.upload.host}")
    private String host;
    @Value("${tea-store.upload.base-dir-name}")
    private String baseDirName;
    @Value("${tea-store.upload.root-dir-name}")
    private String uploadRootDirName;
    @Value("${tea-store.upload.article-image.max-size}")
    private Long articleImageMaxSize;
    @Value("${tea-store.upload.article-image.types}")
    private List<String> articleImageValidTypes;

    private final String articleImageDirName = "article-image/";
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/");

    public ResourceController() {
        log.debug("创建控制器对象: ResourceController");
    }

    @ApiOperation(value = "图片上传")
    @PostMapping("/upload/image/article")
    public JsonResult uploadProductImage(@RequestParam("file") MultipartFile multipartFile) throws Throwable {
        if (multipartFile == null || multipartFile.isEmpty()) {
            String message = "上传文章图片失败，请选择您要上传的文件!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPLOAD_EMPTY, message);
        }

        long size = multipartFile.getSize();
        if (size > articleImageMaxSize * 1024 * 1024) {
            String message = "上传文章图片失败，允许上传图片的最大为" + articleImageMaxSize + "MB !";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPLOAD_EXCEED_MAX_SIZE, message);
        }

        String contentType = multipartFile.getContentType();
        if (!articleImageValidTypes.contains(contentType)) {
            String message = "上传文章图片失败，只允许上传" + articleImageValidTypes + "格式的图片 !";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPLOAD_INVALID_TYPE, message);
        }

        String dirName = simpleDateFormat.format(new Date());
        File uploadBaseDir = new File(uploadRootDirName, baseDirName);
        File articleImageDir = new File(uploadBaseDir, articleImageDirName);
        File uploadDir = new File(articleImageDir, dirName);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String newFileName = UUID.randomUUID().toString();
        String originalFilename = multipartFile.getOriginalFilename();
        assert originalFilename != null;
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFullFilName = newFileName + suffix;
        File file = new File(uploadDir, newFullFilName);
        multipartFile.transferTo(file);

        String url = new StringBuilder()
                .append(host)
                .append(baseDirName)
                .append(articleImageDirName)
                .append(dirName)
                .append(newFullFilName)
                .toString();

        UploadResultVO uploadResultVO = new UploadResultVO();
        uploadResultVO.setUrl(url).setContentType(contentType).setFileName(newFullFilName).setFileSize(size);

        return JsonResult.ok(uploadResultVO);
    }
}
