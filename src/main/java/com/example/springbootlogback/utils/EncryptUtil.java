package com.example.springbootlogback.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class EncryptUtil {

	public static final String HMACSHA512 = "HmacSHA512";


	public static final String       CHARS      = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	public static final String       INITVECTOR = "ttYoCVAj9UbiHbYL";
	public static final SecureRandom rnd        = new SecureRandom();
	public static final String       DELIMITED  = "|;|";

	public static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);


	public static final String AES_MODE = "AES/CBC/PKCS5PADDING";
	/**
	 *
	 * @param secret     16 character
	 * @param initVector 16 character always changed
	 * @param text
	 * @return
	 */
	public static String encryptAES(String secret, String text,String initVector) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "AES");
		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
		Cipher cipher = Cipher.getInstance(AES_MODE);
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		byte[] digest = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
		byte[] encodeBase64 = Base64.encodeBase64(digest);
		return new String(encodeBase64, StandardCharsets.UTF_8);
	}

	/**
	 *
	 * @param secret     16 character
	 * @param initVector 16 character always changed
	 * @return
	 */
	public static String decryptAES(String secret, String encrypted,String initVector) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "AES");
		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
		Cipher cipher = Cipher.getInstance(AES_MODE);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
		byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
		return new String(original, StandardCharsets.UTF_8);
	}
}
