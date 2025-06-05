package com.example.springbootlogback.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootlogback.service.EncryptionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description
 * @Author Mico
 * @Date 2025/3/5 下午2:38
 */
@RestController
public class EncryptionController {
    @Resource
    private EncryptionService encryptionService;

    /**
     *
     * @param encryptedText
     * @return
     */
    @PostMapping("/decrypt")
    public String decrypt(String encryptedText) {
        String decrypt = encryptionService.decrypt(encryptedText);
        System.out.println("decrypt = " + decrypt);
        String encrypt = encryptionService.encrypt(decrypt);
        System.out.println("encrypt = " + encrypt);
        return decrypt;
    }

    /**
     * @return
     */
    @PostMapping("/encrypt")
    public String encrypt(@RequestBody Map<String,Object> map) {
        String encrypt = encryptionService.encrypt(JSON.toJSONString(map));
        System.out.println("encrypt = " + encrypt);
        String decrypt = encryptionService.decrypt(encrypt);
        System.out.println("decrypt = " + decrypt);
        return encrypt;
    }
}
