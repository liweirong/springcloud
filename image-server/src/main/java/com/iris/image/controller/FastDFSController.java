package com.iris.image.controller;

import com.iris.image.util.FastDFSClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author iris
 * @date 2020/5/21
 */
@RestController
public class FastDFSController {

    @Autowired
    private FastDFSClientWrapper fastDFSClient;

    @PostMapping("/upload/images")
    public String saveFile(MultipartFile multipartFile) throws Exception {
        String s = fastDFSClient.uploadFile(multipartFile);
        String tokenUrl = fastDFSClient.getTokenUrl(s);
        System.out.println(">>>>> "+tokenUrl);
        return tokenUrl;
    }
    @PostMapping("/upload/images/")
    public String getToken(@RequestBody String fileUrl){
        String tokenUrl = null;
        try {
            tokenUrl = fastDFSClient.getTokenUrl("group1/M00/00/00/wKirDF7Kdg6AR3ZqAABTdUPArAY926.jpg");
        } catch (Exception e) {
           return "no such images";
        }
        System.out.println(">>>>> "+tokenUrl);
        return tokenUrl;
    }

    @DeleteMapping("/upload/images/")
    public String deleteImages(@RequestBody String fileUrl){
        Boolean aBoolean = fastDFSClient.deleteFile("group1/M00/00/00/wKirDF7Kdg6AR3ZqAABTdUPArAY926.jpg");
        return ""+ aBoolean;
    }


}
