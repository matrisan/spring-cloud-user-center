package com.github.user.center.application.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;

/**
 * TODO
 * <p>
 * create in 2021/5/9 2:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class PhoneNotFoundException extends AuthenticationException {

    public PhoneNotFoundException(String msg) {
        super(msg);
    }

    public PhoneNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
