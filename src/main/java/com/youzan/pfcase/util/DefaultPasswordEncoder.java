package com.youzan.pfcase.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.NoSuchAlgorithmException;

/**
 * 默认的密码校验器
 */
public class DefaultPasswordEncoder implements PasswordEncoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPasswordEncoder.class);

    @Override
    public String encode(CharSequence rawPassword) {
        try {
            return EncryptionUtil.defaultEncrypt(rawPassword.toString());
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("encrypt password failed.");
            return null;
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return null != rawPassword && encode(rawPassword).equals(encodedPassword);
    }
}
