package com.taotao.manager.service.impl;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.utils.FastdfsClient;
import com.taotao.manager.service.PictureService;

import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by liuhang on 2017/3/1.
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Value("${imageServerBaseUrl}")
    private String imageServerBaseUrl;

    @Override
    public PictureResult uploadPicture(MultipartFile uploadFile) {
        PictureResult pictureResult = new PictureResult();
        if (uploadFile.isEmpty()) {
            pictureResult.setError(1);
            pictureResult.setMessage("图片为空");
            return pictureResult;
        }
        try {
            FastdfsClient fastdfsClient = new FastdfsClient("properties/fastdfs.conf");
            String url = fastdfsClient.uploadFile(uploadFile.getBytes());
//            String url = fastdfsClient.uploadFile(uploadFile.getOriginalFilename());
            pictureResult.setError(0);
            url = imageServerBaseUrl + url;
            pictureResult.setUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
            pictureResult.setError(1);
            pictureResult.setMessage("图片上传失败");
        } catch (MyException e) {
            e.printStackTrace();
            pictureResult.setError(1);
            pictureResult.setMessage("图片上传失败");
        }

        return pictureResult;
    }
}
