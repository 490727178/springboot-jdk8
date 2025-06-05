package com.example.springbootlogback.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * RSA 加密工具类
 * RSA Encryption Utility Class
 *
 * @Description 提供 RSA 加密和解密功能，包括生成密钥对、编码和解码公钥/私钥、分段加密和解密。
 * @Description Provides RSA encryption and decryption functionalities, including generating key pairs, encoding and decoding public/private keys, and segment encryption and decryption.
 */
public class RSAEncryptionUtilNew {

    /**
     * RSA 算法名称
     * RSA algorithm name
     */
    private static final String ALGORITHM = "RSA";

    /**
     * RSA 加密/解密转换模式
     * RSA encryption/decryption transformation mode
     */
    private static final String TRANSFORMATION = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /**
     * 最大加密块大小（对于 2048 位密钥）
     * Maximum encryption block size (for 2048-bit key)
     */
    private static final int MAX_ENCRYPT_BLOCK = 190;

    /**
     * 最大解密块大小（对于 2048 位密钥）
     * Maximum decryption block size (for 2048-bit key)
     */
    private static final int MAX_DECRYPT_BLOCK = 256;

    /**
     * 从指定路径获取公钥
     * Get public key from specified path
     *
     * @param path 公钥文件路径
     * @param path Path to the public key file
     * @return 公钥对象
     * @return Public key object
     * @throws IOException 如果文件读取失败
     * @throws IOException If file reading fails
     */
    public static PublicKey getPublicKey(String path) throws IOException {
        String keyBase64 = getKeyBase64(path);
        try {
            return RSAEncryptionUtil.decodePublicKey(keyBase64);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 从指定路径获取私钥
     * Get private key from specified path
     *
     * @param path 私钥文件路径
     * @param path Path to the private key file
     * @return 私钥对象
     * @return Private key object
     * @throws IOException 如果文件读取失败
     * @throws IOException If file reading fails
     */
    public static PrivateKey getPrivateKey(String path) throws IOException {
        String keyBase64 = getKeyBase64(path);
        try {
            return RSAEncryptionUtil.decodePrivateKey(keyBase64);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 从指定路径获取 Base64 编码的密钥字符串
     * Get Base64 encoded key string from specified path
     *
     * @param path 密钥文件路径
     * @param path Path to the key file
     * @return Base64 编码的密钥字符串
     * @return Base64 encoded key string
     * @throws IOException 如果文件读取失败
     * @throws IOException If file reading fails
     */
    private static String getKeyBase64(String path) throws IOException {
        Resource resource;

        // 检查路径是否为绝对路径
        // Check if the path is an absolute path
        if (new File(path).isAbsolute()) {
            resource = new FileSystemResource(path);
        } else {
            resource = new ClassPathResource(path);
        }
        if (!resource.exists()) {
            throw new IOException("Resource not found: " + path);
        }

        File file = resource.getFile();
        if (!file.exists()) {
            throw new IOException("File not found: " + file.getAbsolutePath());
        }

        return new String(Files.readAllBytes(resource.getFile().toPath()));
    }

    /**
     * 生成 RSA 密钥对
     * Generate RSA key pair
     *
     * @return 包含公钥和私钥的 KeyPair 对象
     * @return KeyPair object containing public and private keys
     * @throws NoSuchAlgorithmException 如果指定的算法不可用
     * @throws NoSuchAlgorithmException If the specified algorithm is unavailable
     */
    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    /**
     * 将公钥编码为 Base64 字符串
     * Encode public key as a Base64 string
     *
     * @param publicKey 公钥对象
     * @param publicKey Public key object
     * @return Base64 编码的公钥字符串
     * @return Base64 encoded string of the public key
     */
    public static String encodePublicKey(PublicKey publicKey) {
        return Base64.getUrlEncoder().encodeToString(publicKey.getEncoded());
    }

    /**
     * 将私钥编码为 Base64 字符串
     * Encode private key as a Base64 string
     *
     * @param privateKey 私钥对象
     * @param privateKey Private key object
     * @return Base64 编码的私钥字符串
     * @return Base64 encoded string of the private key
     */
    public static String encodePrivateKey(PrivateKey privateKey) {
        return Base64.getUrlEncoder().encodeToString(privateKey.getEncoded());
    }

    /**
     * 从 Base64 编码字符串解码公钥
     * Decode public key from Base64 encoded string
     *
     * @param publicKeyStr Base64 编码的公钥字符串
     * @param publicKeyStr Base64 encoded string of the public key
     * @return 公钥对象
     * @return Public key object
     * @throws Exception 如果解码过程中发生异常
     * @throws Exception If an exception occurs during decoding
     */
    public static PublicKey decodePublicKey(String publicKeyStr) throws Exception {
        byte[] keyBytes = Base64.getUrlDecoder().decode(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * 从 Base64 编码字符串解码私钥
     * Decode private key from Base64 encoded string
     *
     * @param privateKeyStr Base64 编码的私钥字符串
     * @param privateKeyStr Base64 encoded string of the private key
     * @return 私钥对象
     * @return Private key object
     * @throws Exception 如果解码过程中发生异常
     * @throws Exception If an exception occurs during decoding
     */
    public static PrivateKey decodePrivateKey(String privateKeyStr) throws Exception {
        byte[] keyBytes = Base64.getUrlDecoder().decode(privateKeyStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 分段加密方法
     * Segment encryption method
     *
     * @param publicKey 公钥
     * @param publicKey Public key
     * @param plainText 明文
     * @param plainText Plain text
     * @return Base64 编码的密文
     * @return Base64 encoded cipher text
     * @throws Exception 如果加密失败
     * @throws Exception If encryption fails
     */
    public static String encrypt(PublicKey publicKey, String plainText) throws Exception {
        byte[] data = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedData = segmentProcess(data, publicKey, Cipher.ENCRYPT_MODE, MAX_ENCRYPT_BLOCK);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(encryptedData);
    }

    /**
     * 分段解密方法
     * Segment decryption method
     *
     * @param privateKey 私钥
     * @param privateKey Private key
     * @param encryptedText Base64 编码的密文
     * @param encryptedText Base64 encoded cipher text
     * @return 解密后的明文
     * @return Decrypted plain text
     * @throws Exception 如果解密失败
     * @throws Exception If decryption fails
     */
    public static String decrypt(PrivateKey privateKey, String encryptedText) throws Exception {
        byte[] encryptedData = Base64.getUrlDecoder().decode(encryptedText);
        byte[] decryptedData = segmentProcess(encryptedData, privateKey, Cipher.DECRYPT_MODE, MAX_DECRYPT_BLOCK);
        return new String(decryptedData, StandardCharsets.UTF_8);
    }

    /**
     * 分段处理方法
     * Segment processing method
     *
     * @param data 数据字节数组
     * @param data Data byte array
     * @param key 密钥（公钥或私钥）
     * @param key Key (public or private key)
     * @param mode 模式（加密或解密）
     * @param mode Mode (encryption or decryption)
     * @param maxBlock 处理的最大块大小
     * @param maxBlock Maximum block size for processing
     * @return 处理后的数据字节数组
     * @return Processed data byte array
     * @throws Exception 如果处理过程中发生异常
     * @throws Exception If an exception occurs during processing
     */
    private static byte[] segmentProcess(byte[] data, Key key, int mode, int maxBlock) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(mode, key);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int inputLen = data.length;
            int offSet = 0;

            while (offSet < inputLen) {
                int processLen = Math.min(maxBlock, inputLen - offSet);
                byte[] cache = cipher.doFinal(data, offSet, processLen);
                out.write(cache, 0, cache.length);
                offSet += processLen;
            }
            return out.toByteArray();
        } catch (IOException e) {
            throw new IllegalStateException("ByteArrayOutputStream error", e);
        }
    }
}
