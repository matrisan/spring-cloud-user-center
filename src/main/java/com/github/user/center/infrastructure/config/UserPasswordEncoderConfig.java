package com.github.user.center.infrastructure.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * <p>
 * create in 2021/5/10 8:59 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Configuration
@RequiredArgsConstructor
public class UserPasswordEncoderConfig {

    @Bean
    public PasswordEncoder createDelegatingPasswordEncoder() {
        log.debug("初始化密码加解密器");
        String encodingId = "bcrypt";
        Map<String, PasswordEncoder> encoders = new HashMap<>(5);
        encoders.put(encodingId, new BCryptPasswordEncoder());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        return new DelegatingPasswordEncoder(encodingId, encoders);
    }

}
