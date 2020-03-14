package com.tt.backend.item.service;

import com.tt.utils.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: blackcat
 * @Date: 2020-01-31
 * @Description: com.tt.backend.item.service
 * @version:
 */
public interface FileUploadService {

    public Result fileUpload(MultipartFile file);
}
