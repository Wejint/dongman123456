package com.wejint.video.service;

import com.aliyun.sts20150401.models.AssumeRoleResponseBody;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface VideoService {

    Map<String, String> getPostSignatureForOssUpload() throws Exception;
}
