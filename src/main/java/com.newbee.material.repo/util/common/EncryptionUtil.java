package com.newbee.material.repo.util.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密帮助类
 */
public class EncryptionUtil {

	private static final Log LOGGER = LogFactory.getLog(EncryptionUtil.class);

	public static String encryptSha512(final String text)
			throws NoSuchAlgorithmException, IllegalArgumentException {
		return encrypt(text, "SHA-512");
	}

	private static String encrypt(final String plainText, final String algorithm)
			throws NoSuchAlgorithmException, IllegalArgumentException {

		// 是否是有效字符串
		if (plainText != null && !plainText.isEmpty()) {
			try {
				// SHA 加密开始
				// 创建加密对象 并傳入加密類型
				MessageDigest messageDigest = MessageDigest
						.getInstance(algorithm);
				// 传入要加密的字符串
				messageDigest.update(plainText.getBytes());
				// 得到 byte 類型结果
				byte byteBuffer[] = messageDigest.digest();

				// 將 byte 轉換爲 string
				StringBuffer strHexString = new StringBuffer();
				// 遍歷 byte buffer
				for (int i = 0; i < byteBuffer.length; i++) {
					String hex = Integer.toHexString(0xff & byteBuffer[i]);
					if (hex.length() == 1) {
						strHexString.append('0');
					}
					strHexString.append(hex);
				}
				// 得到返回結果
				return strHexString.toString();
			} catch (NoSuchAlgorithmException e) {
				LOGGER.error("Encrypt failed.");
				throw e;
			}
		}
		throw new IllegalArgumentException("Plain text illegal.");

	}
}
