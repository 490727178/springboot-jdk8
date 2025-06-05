package com.example.springbootlogback.service;

import com.example.springbootlogback.config.RSAConfig;
import com.example.springbootlogback.utils.KeyUtil;
import com.example.springbootlogback.utils.RSAEncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.PrivateKey;
import java.security.PublicKey;

@Service
public class EncryptionService {

    private final RSAConfig rsaConfig;
    private PublicKey publicKey;
    private PrivateKey privateKey;

    @Autowired
    public EncryptionService(RSAConfig rsaConfig) {
        this.rsaConfig = rsaConfig;
    }

    @PostConstruct
    public void init() throws Exception {
        this.publicKey = KeyUtil.getPublicKey(rsaConfig.getPublicKeyPath());
        this.privateKey = KeyUtil.getPrivateKey(rsaConfig.getPrivateKeyPath());
    }

    public String encrypt(String plainText) {
        try {
            return RSAEncryptionUtil.encrypt(publicKey, plainText);
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed", e);
        }
    }

    public String decrypt(String encryptedText) {
        try {
            return RSAEncryptionUtil.decrypt(privateKey, encryptedText);
        } catch (Exception e) {
            throw new RuntimeException("Decryption failed", e);
        }
    }
}
