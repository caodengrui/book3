package com.cdr.book.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/pic")
public class PicController {
    @RequestMapping("/uploadPic")
    public String uploadPic(MultipartFile file){
        String fileName = file.getOriginalFilename();
        String folder = "D:\\IdeaWorkSpace\\book\\src\\main\\resources\\static\\image";
        File imageFolder = new File(folder);
        Date date = new Date();
        //拼接生成新图片名字用的时间戳
        String newFileName = Long.toString(date.getTime()) + fileName;
        File f = new File(imageFolder, newFileName);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);//SpringMVC上传保存文件方法
            String picURL = "http://localhost:8181/api/file/" + f.getName();
            return picURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
