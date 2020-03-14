package com.tt.backend.item.service.impl;

import com.tt.backend.item.service.FileUploadService;
import com.tt.utils.FtpUtil;
import com.tt.utils.IDUtils;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 上传图片service
 * @Auther: blackcat
 * @Date: 2020-01-31
 * @Description: com.tt.backend.item.service.impl
 * @version:
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    /*FTP_HOST: 192.168.207.30
    FTP_PORT: 21
    FTP_USERNAME: ftpuser
    FTP_PASSWORD: ftpuser
    FTP_BASEPATH: /home/ftpuser/*/
    @Value("${FTP_HOST}")
    private String FTP_HOST;
    @Value("${FTP_PORT}")
    private int FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASEPATH}")
    private String FTP_BASEPATH;

    @Override
    public Result fileUpload(MultipartFile file) {
        //定义上传图片的目录结构
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        String path = sdf.format(new Date());
        // 设置新文件名
        String newFileName = IDUtils.genImageName() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        try {
            FtpUtil.uploadFile(FTP_HOST,FTP_PORT,FTP_USERNAME,FTP_PASSWORD,FTP_BASEPATH,path,newFileName,file.getInputStream());
            String imageURL = "http://"+FTP_HOST+path+newFileName;

            return Result.ok(imageURL);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
