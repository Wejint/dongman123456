package com.wejint.video.controller;

import com.wejint.video.service.VideoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.nio.file.*;

import java.util.Map;

@RestController
@RequestMapping("/video")
public class VideoController {
    @Resource
    VideoService videoServiceImpl;
    @Value("${video.storage.location}")
    private String storageLocation;
    @GetMapping("/get_post_signature_for_oss_upload")
    public ResponseEntity<Map<String, String>> getPostSignatureForOssUpload() throws Exception {
        Map<String,String> response = videoServiceImpl.getPostSignatureForOssUpload();
        // 返回带有状态码 200 (OK) 的 ResponseEntity，返回给Web端，进行PostObject操作
        return ResponseEntity.ok(response);
    }

    @GetMapping("/play/{filename}")
    public ResponseEntity<org.springframework.core.io.Resource> playVideo(@PathVariable String filename) {
        try {
            Path filePath = Paths.get(storageLocation + filename);
            org.springframework.core.io.Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType("video/mp4"))  // 根据实际格式调整
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
