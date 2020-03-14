package com.tt.backend.item.controller;

import com.tt.backend.item.service.FileUploadService;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传
 * @Auther: blackcat
 * @Date: 2020-01-31
 * @Description: com.tt.backend.item.controller
 * @version:
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping("/upload")
    public Result fileUpload(MultipartFile file){
        try {
            return this.fileUploadService.fileUpload(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

}
