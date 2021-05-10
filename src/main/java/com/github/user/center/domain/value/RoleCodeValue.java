package com.github.user.center.domain.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Transient;

/**
 * TODO
 * <p>
 * create in 2021/5/8 11:27 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Value
public class RoleCodeValue {

    @Transient
    @JsonIgnore
    private static final String PREFIX = "ROLE_";

    String roleCode;

    public RoleCodeValue(String roleCode) {
        if (!StringUtils.startsWith(roleCode, PREFIX)) {
            throw new RuntimeException();
        }
        this.roleCode = roleCode;
    }
}
