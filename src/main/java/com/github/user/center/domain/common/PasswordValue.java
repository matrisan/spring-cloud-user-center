package com.github.user.center.domain.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * <p>
 * create in 2021/5/10 8:05 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */


@Embeddable
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class PasswordValue implements Serializable {

    private static final long serialVersionUID = -4207192967941370239L;

    @Transient
    static final int LENGTH = 5;

    @Transient
    static final int EXPIRATION = 180;

    String currentPassword;

    Map<LocalDate, String> historyPassword = new HashMap<>();

    public PasswordValue(String password) {
        this.currentPassword = password;
    }


}
