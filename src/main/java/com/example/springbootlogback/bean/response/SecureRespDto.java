package com.example.springbootlogback.bean.response;

import lombok.Data;

/**
 * Secure resp
 * @Description
 * @Author Mico
 * @Date 2024/11/22 下午4:05
 */
@Data
public class SecureRespDto {
    private String data;

    private String keyLabel;

    private String iv;
}
