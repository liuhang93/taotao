package com.taotao.manager.controller;

import com.taotao.common.pojo.PictureResult;
import com.taotao.manager.service.PictureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by liuhang on 2017/3/1.
 * 图片上传controller
 */
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public PictureResult upload(@RequestParam("uploadFile") MultipartFile multipartFile) {
        return pictureService.uploadPicture(multipartFile);
    }
}
