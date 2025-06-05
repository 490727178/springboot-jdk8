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
 * RSA encryption/decryption utility with segmented processing support
 *
 * <p>Provides functionality for:
 * - Key pair generation
 * - Key encoding/decoding (Base64 URL-safe format)
 * - File-based key loading
 * - Data segmentation for large payloads
 */
public class RSAEncryptionUtil {

    /** RSA algorithm identifier */
    private static final String ALGORITHM = "RSA";

    /** Cipher transformation with OAEP padding */
    private static final String TRANSFORMATION = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /** Maximum encryption block size for 2048-bit keys */
    private static final int MAX_ENCRYPT_BLOCK = 190;

    /** Maximum decryption block size for 2048-bit keys */
    private static final int MAX_DECRYPT_BLOCK = 256;

    /**
     * Loads public key from specified path
     *
     * @param path Absolute path or classpath-relative resource path
     * @return Initialized PublicKey object
     * @throws IOException If file read operation fails
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
     * Loads private key from specified path
     *
     * @param path Absolute path or classpath-relative resource path
     * @return Initialized PrivateKey object
     * @throws IOException If file read operation fails
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
     * Reads Base64-encoded key from file
     *
     * @param path Key file path (absolute or classpath-relative)
     * @return Base64-encoded key string
     * @throws IOException If file not found or read fails
     */
    private static String getKeyBase64(String path) throws IOException {
        Resource resource;

        // Determine resource type based on path
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
     * Generates 2048-bit RSA key pair
     *
     * @return New KeyPair instance
     * @throws NoSuchAlgorithmException If RSA implementation is unavailable
     */
    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    /**
     * Encodes public key to Base64 URL-safe string
     *
     * @param publicKey Public key to encode
     * @return Base64-encoded string
     */
    public static String encodePublicKey(PublicKey publicKey) {
        return Base64.getUrlEncoder().encodeToString(publicKey.getEncoded());
    }

    /**
     * Encodes private key to Base64 URL-safe string
     *
     * @param privateKey Private key to encode
     * @return Base64-encoded string
     */
    public static String encodePrivateKey(PrivateKey privateKey) {
        return Base64.getUrlEncoder().encodeToString(privateKey.getEncoded());
    }

    /**
     * Decodes public key from Base64 string
     *
     * @param publicKeyStr Base64-encoded public key
     * @return Initialized PublicKey object
     * @throws Exception If decoding fails
     */
    public static PublicKey decodePublicKey(String publicKeyStr) throws Exception {
        byte[] keyBytes = Base64.getUrlDecoder().decode(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * Decodes private key from Base64 string
     *
     * @param privateKeyStr Base64-encoded private key
     * @return Initialized PrivateKey object
     * @throws Exception If decoding fails
     */
    public static PrivateKey decodePrivateKey(String privateKeyStr) throws Exception {
        byte[] keyBytes = Base64.getUrlDecoder().decode(privateKeyStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * Encrypts plaintext using public key with segmentation
     *
     * @param publicKey Initialized public key
     * @param plainText Text to encrypt
     * @return Base64-encoded ciphertext
     * @throws Exception If encryption fails
     */
    public static String encrypt(PublicKey publicKey, String plainText) throws Exception {
        byte[] data = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedData = segmentProcess(data, publicKey, Cipher.ENCRYPT_MODE, MAX_ENCRYPT_BLOCK);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(encryptedData);
    }

    /**
     * Decrypts ciphertext using private key with segmentation
     *
     * @param privateKey Initialized private key
     * @param encryptedText Base64-encoded ciphertext
     * @return Decrypted plaintext
     * @throws Exception If decryption fails
     */
    public static String decrypt(PrivateKey privateKey, String encryptedText) throws Exception {
        byte[] encryptedData = Base64.getUrlDecoder().decode(encryptedText);
        byte[] decryptedData = segmentProcess(encryptedData, privateKey, Cipher.DECRYPT_MODE, MAX_DECRYPT_BLOCK);
        return new String(decryptedData, StandardCharsets.UTF_8);
    }

    /**
     * Processes data in segments using specified cryptographic operation
     *
     * @param data Input data bytes
     * @param key Cryptographic key (public or private)
     * @param mode Cipher mode (ENCRYPT_MODE or DECRYPT_MODE)
     * @param maxBlock Maximum block size for operation
     * @return Processed data bytes
     * @throws Exception If cryptographic operation fails
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