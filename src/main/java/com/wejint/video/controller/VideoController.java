package com.wejint.video.controller;

import com.wejint.video.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class VideoController {
    @Resource
    VideoService videoServiceImpl;

    @GetMapping("/get_post_signature_for_oss_upload")
    public ResponseEntity<Map<String, String>> getPostSignatureForOssUpload() throws Exception {
        Map<String,String> response = videoServiceImpl.getPostSignatureForOssUpload();
        // 返回带有状态码 200 (OK) 的 ResponseEntity，返回给Web端，进行PostObject操作
        return ResponseEntity.ok(response);
    }
}
