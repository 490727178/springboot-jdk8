package com.example.springbootlogback.bean.request;

import lombok.Data;

/**
 *  Secure Member Req
 * @Description
 * @Author Mico
 * @Date 2024/11/22 下午4:05
 */
@Data
public class SecureBean {
    /**
     * 加密后的字符串
     */
    private String data;

    /**
     * 加密iv
     */
    private String iv;

    /**
     * 加密keyLabel
     */
    private String keyLabel;

    /**
     * 解密后的字符串
     */
    private String decryptData;

    /**
     * 加密秘钥
     */
    private String key;

    /**
     * 需要加密的json字符串
     */
    private String jsonStr;
}
