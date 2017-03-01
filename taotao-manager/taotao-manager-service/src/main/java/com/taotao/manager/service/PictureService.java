package com.taotao.manager.service;

import com.taotao.common.pojo.PictureResult;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by liuhang on 2017/3/1.
 */
public interface PictureService {
    PictureResult uploadPicture(MultipartFile uploadFile);
}
