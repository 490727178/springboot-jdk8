package com.example.springbootlogback.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyUtil {

    public static PublicKey getPublicKey(String path) throws IOException {
        Resource resource;

        // 判断是否是绝对路径
        if (new File(path).isAbsolute()) {
            resource = new FileSystemResource(path);
        } else {
            resource = new ClassPathResource(path);
        }

        String publicKeyBase64 = new String(Files.readAllBytes(resource.getFile().toPath()));
        try {
            return RSAEncryptionUtil.decodePublicKey(publicKeyBase64);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PrivateKey getPrivateKey(String path) throws IOException {
        Resource resource;
        // 判断是否是绝对路径
        if (new File(path).isAbsolute()) {
            resource = new FileSystemResource(path);
        } else {
            resource = new ClassPathResource(path);
        }
        String privateKeyBase64 = new String(Files.readAllBytes(resource.getFile().toPath()));
        try {
            return RSAEncryptionUtil.decodePrivateKey(privateKeyBase64);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        try {
            KeyPair keyPair = RSAEncryptionUtil.generateKeyPair();
            System.out.println("publicKey: "+ RSAEncryptionUtil.encodePublicKey(keyPair.getPublic()));
            System.out.println("privateKey: "+ RSAEncryptionUtil.encodePrivateKey(keyPair.getPrivate()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
