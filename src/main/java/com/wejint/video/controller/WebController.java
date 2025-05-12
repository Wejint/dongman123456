package com.wejint.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.aliyun.sts20150401.models.AssumeRoleResponse;
import com.aliyun.sts20150401.models.AssumeRoleResponseBody;
import com.aliyun.tea.TeaException;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.Instant;

@Controller
public class WebController {



    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello Thymeleaf");
        return "index"; // 对应templates/index.html
    }
}
